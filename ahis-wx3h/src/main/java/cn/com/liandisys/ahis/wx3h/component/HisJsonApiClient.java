package cn.com.liandisys.ahis.wx3h.component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.com.liandisys.ahis.wx3h.entity.request.BaseRequest;
import net.sf.json.JSONObject;

@Component
public class HisJsonApiClient {
	
	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(HisJsonApiClient.class);

	private static final String encode = "UTF-8";
	private static final int soTimeout = 30;

	public <E extends BaseRequest> JSONObject executeHisApi(String apiPath, E paramsEntity) {

		ConnectionConfig coConfig = ConnectionConfig.custom().setCharset(Charset.forName(encode)).build();
		SocketConfig soConfig = SocketConfig.custom().setSoTimeout(soTimeout * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultConnectionConfig(coConfig)
				.setDefaultSocketConfig(soConfig).build();

		String baseUrl = env.getProperty("his.wx3h.base.url");
		HttpPost httpUriRequest = new HttpPost(baseUrl + apiPath);
		httpUriRequest.setHeader("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		httpUriRequest.setHeader("Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		try {
			httpUriRequest.setEntity(getHttpEntity(paramsEntity));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// 执行post请求
			HttpResponse httpResponse = client.execute(httpUriRequest);
			logger.debug("Status Code:" + httpResponse.getStatusLine().getStatusCode());
			// 获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();
			entity.getContentType();
			// 判断响应实体是否为空
			if (entity != null) {
				return convertResponse(entity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private <E extends BaseRequest> HttpEntity getHttpEntity(E paramsEntity) throws JAXBException {
		String xmlTextStr = convertToXmlStr(paramsEntity);
		logger.info(xmlTextStr);
		List<NameValuePair> nvp = new ArrayList<NameValuePair>();
		nvp.add(new BasicNameValuePair("xmlText", xmlTextStr));
		try {
			return new StringEntity(URLEncodedUtils.format(nvp, encode));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
//		StringBuilder sb = new StringBuilder();
//		sb.append("xmlText=");
//		sb.append(xmlTextStr);
//		return new StringEntity(sb.toString());
	}

	private JSONObject convertResponse(HttpEntity entity)
			throws ParseException, IOException {
		String xml = StringEscapeUtils.unescapeXml(EntityUtils.toString(entity, encode));
		System.out.println(xml);
		org.json.JSONObject jsonObjRoot = XML.toJSONObject(xml);
		org.json.JSONObject jsonObjString = jsonObjRoot.getJSONObject("string");
		org.json.JSONObject jsonObj = null;
		if(jsonObjString != null){
			jsonObj = jsonObjString.getJSONObject("Response");
		}
		else {
			jsonObj = jsonObjRoot.getJSONObject("Response");
		}
		JSONObject jsonObject = JSONObject.fromObject(jsonObj.toString());
		return jsonObject;
	}

	/**
	 * 将对象直接转换成String类型的 XML输出
	 * 
	 * @param obj
	 * @return
	 */
	private static <T extends BaseRequest> String convertToXmlStr(T obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		StringBuilder sb = new StringBuilder();
		sb.append("<Request>");
		for(Field f : fields){
			f.setAccessible(true); //设置些属性是可以访问的  
			Object val = null;
			try {
				val = f.get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}//得到此属性的值

			if(StringUtils.isEmpty(val)){
				sb.append("<").append(f.getName()).append("/>");
			}
			else {
				sb.append("<").append(f.getName()).append(">");
				sb.append(val);
				sb.append("</").append(f.getName()).append(">");
			}
		}
		sb.append("</Request>");
		return sb.toString();
	}

}