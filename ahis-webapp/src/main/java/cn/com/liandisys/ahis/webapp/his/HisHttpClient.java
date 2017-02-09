package cn.com.liandisys.ahis.webapp.his;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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

import cn.com.liandisys.ahis.webapp.his.entity.request.BaseRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.BaseResponse;

public class HisHttpClient {
	private static final Logger logger = LoggerFactory.getLogger(HisHttpClient.class);

	private static final String baseUrl = "http://localhost:8081/mock";
	private static final String encode = "UTF-8";
	private static final int soTimeout = 30;

	public static <T extends BaseResponse> T executeHisApi(String apiPath, BaseRequest request, Class<?> requestClazz,
			Class<?> responseClazz) throws UnsupportedEncodingException, JAXBException {

		ConnectionConfig coConfig = ConnectionConfig.custom().setCharset(Charset.forName(encode)).build();
		SocketConfig soConfig = SocketConfig.custom().setSoTimeout(soTimeout * 1000).build();
		CloseableHttpClient client = HttpClientBuilder.create().setDefaultConnectionConfig(coConfig)
				.setDefaultSocketConfig(soConfig).build();

		HttpPost httpUriRequest = new HttpPost(baseUrl + apiPath);
		httpUriRequest.setHeader("Content-Type", MediaType.APPLICATION_XML_VALUE);
		httpUriRequest.setHeader("Accept", MediaType.APPLICATION_XML_VALUE);
		httpUriRequest.setEntity(getHttpEntity(requestClazz, request));

		try {
			// 执行post请求
			HttpResponse httpResponse = client.execute(httpUriRequest);
			logger.debug("Status Code:" + httpResponse.getStatusLine().getStatusCode());
			// 获取响应消息实体
			HttpEntity entity = httpResponse.getEntity();
			entity.getContentType();
			// 判断响应实体是否为空
			if (entity != null) {
				return convertResponse(responseClazz, entity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
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

	private static HttpEntity getHttpEntity(Class<?> clazz, BaseRequest request)
			throws JAXBException, UnsupportedEncodingException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Marshaller marshaller = jc.createMarshaller();
		StringWriter sw = new StringWriter();
		marshaller.marshal(request, sw);
		logger.info(sw.toString());
		return new StringEntity(sw.toString(), Charset.forName(encode));
	}

	@SuppressWarnings("unchecked")
	private static <T extends BaseResponse> T convertResponse(Class<?> clazz, HttpEntity entity)
			throws JAXBException, ParseException, IOException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
		return (T) jaxbUnmarshaller.unmarshal(new StringReader(EntityUtils.toString(entity, encode)));
	}
}