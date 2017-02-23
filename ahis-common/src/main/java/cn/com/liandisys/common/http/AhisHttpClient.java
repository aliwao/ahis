package cn.com.liandisys.common.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AhisHttpClient {

    private static Logger logger = LoggerFactory.getLogger(AhisHttpClient.class);

    public static String executeApi(AhisHttpClientConfig config, List<NameValuePair> params)
            throws UnsupportedEncodingException {

        ConnectionConfig coConfig = ConnectionConfig.custom().setCharset(Charset.forName(config.getEncode())).build();
        SocketConfig soConfig = SocketConfig.custom().setSoTimeout(config.getSoTimeout() * 1000).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultConnectionConfig(coConfig)
                .setDefaultSocketConfig(soConfig).build();

        HttpPost httpUriRequest = new HttpPost(config.getUri());
        httpUriRequest.setHeader("Content-Type", config.getContentType());
        httpUriRequest.setHeader("Accept", config.getAccept());
        httpUriRequest.setEntity(new UrlEncodedFormEntity(params, Charset.forName(config.getEncode())));
        try {
            // 执行post请求
            HttpResponse httpResponse = client.execute(httpUriRequest);
            logger.debug("Status Code:" + httpResponse.getStatusLine().getStatusCode());
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            // 判断响应实体是否为空
            if (entity != null) {
                //System.out.println(EntityUtils.toString(entity));
                return EntityUtils.toString(entity);
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
}
