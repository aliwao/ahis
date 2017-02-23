package cn.com.liandisys.ahis.webapp.his;

import java.io.IOException;
import java.nio.charset.Charset;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.utils.AESUtil;

public class HisHttpJson {
	private static final Logger logger = LoggerFactory.getLogger(HisHttpJson.class);

	private static final String baseUrl = "http://localhost:8082/wx3h/his/";
	private static final String encode = "UTF-8";
	private static final int soTimeout = 30;

	public static JSONObject executeHisApi(String apiPath, JSONObject requestJson) {

		ConnectionConfig coConfig = ConnectionConfig.custom().setCharset(Charset.forName(encode)).build();
		SocketConfig soConfig = SocketConfig.custom().setSoTimeout(soTimeout * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultConnectionConfig(coConfig)
				.setDefaultSocketConfig(soConfig).build();

		HttpPost httpUriRequest = new HttpPost(baseUrl + apiPath);
		httpUriRequest.setHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE);
		httpUriRequest.setHeader("Accept", MediaType.TEXT_PLAIN_VALUE);
		httpUriRequest.setEntity(getHttpEntity(requestJson));

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

	private static HttpEntity getHttpEntity(JSONObject requestJson) {
		logger.info(requestJson.toString());
		// 加密
		String aseStr = AESUtil.encrypt(requestJson.toString());
		return new StringEntity(aseStr, encode);
	}

	private static JSONObject convertResponse(HttpEntity entity) throws ParseException, IOException {
		String resData = EntityUtils.toString(entity);
		JSONObject resJson = null;
		if(resData != null && !"".equals(resData)){
			// 解密
			String aseStr = AESUtil.decrypt(resData);
			resJson = JSONObject.parseObject(aseStr);
		}
		else {
			resJson = new JSONObject();
		}
		return resJson;
	}

}