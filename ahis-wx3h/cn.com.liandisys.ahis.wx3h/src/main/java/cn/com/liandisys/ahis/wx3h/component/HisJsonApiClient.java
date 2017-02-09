package cn.com.liandisys.ahis.wx3h.component;

import java.io.IOException;
import java.nio.charset.Charset;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class HisJsonApiClient {
	
	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(HisJsonApiClient.class);

	private static final String encode = "UTF-8";
	private static final int soTimeout = 30;

	public JSONObject executeHisApi(String apiPath, JSONObject paramsJson) {

		ConnectionConfig coConfig = ConnectionConfig.custom().setCharset(Charset.forName(encode)).build();
		SocketConfig soConfig = SocketConfig.custom().setSoTimeout(soTimeout * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultConnectionConfig(coConfig)
				.setDefaultSocketConfig(soConfig).build();

		String baseUrl = env.getProperty("his.wx3h.base.url");
		HttpPost httpUriRequest = new HttpPost(baseUrl + apiPath);
		httpUriRequest.setHeader("Content-Type", MediaType.APPLICATION_XML_VALUE);
		httpUriRequest.setHeader("Accept", MediaType.APPLICATION_XML_VALUE);
		httpUriRequest.setEntity(getHttpEntity(paramsJson));

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

	private HttpEntity getHttpEntity(JSONObject paramsJson) {
		XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setObjectName("Request");
		String xml = xmlSerializer.write(JSONSerializer.toJSON(paramsJson.toString()));
		return new StringEntity(xml, Charset.forName(encode));
	}

	private JSONObject convertResponse(HttpEntity entity)
			throws ParseException, IOException {
		String xml = EntityUtils.toString(entity, encode);
		org.json.JSONObject jsonObjRoot = XML.toJSONObject(xml);
		org.json.JSONObject jsonObj = jsonObjRoot.getJSONObject("Response");
		// JSON json= new XMLSerializer().read(xml);
		// XMLSerializer xmlSerializer = new XMLSerializer();
		JSONObject jsonObject = JSONObject.fromObject(jsonObj.toString());
		return jsonObject;
	}
}