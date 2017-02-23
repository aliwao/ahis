package cn.com.liandisys.ahis.payment.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import cn.com.liandisys.ahis.payment.form.sltf.QueryForm;
import cn.com.liandisys.ahis.payment.form.sltf.QueryResultForm;
import net.sf.json.JSONObject;

public class HttpClient {

    private static final String encode = "UTF-8";
    private static final int soTimeout = 30;

    private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

//    public static void main(String[] args) {
//        QueryForm qf = new QueryForm();
//        QueryResultForm qrf = new QueryResultForm();
//        List<QueryResultForm> qrfList = new ArrayList<QueryResultForm>();
//        qrfList.add(qrf);
//        qf.setList(qrfList);
//        JSONObject job = JSONObject.fromObject(qf);
//        System.out.println(job.toString());
//        QueryForm f = (QueryForm) JSONObject.toBean(JSONObject.fromObject(job.toString()), QueryForm.class);
//        System.out.println(f.getList().size());
//    }

    public static void executeHisApi(String apiPath, Object requestObj)
            throws UnsupportedEncodingException, JAXBException {

        ConnectionConfig coConfig = ConnectionConfig.custom().setCharset(Charset.forName(encode)).build();
        SocketConfig soConfig = SocketConfig.custom().setSoTimeout(soTimeout * 1000).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultConnectionConfig(coConfig)
                .setDefaultSocketConfig(soConfig).build();

        HttpPost httpUriRequest = new HttpPost(apiPath);
        httpUriRequest.setHeader("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        httpUriRequest.setHeader("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        // httpUriRequest.setEntity(JsonUtil.c(requestObj));

        try {
            // 执行post请求
            HttpResponse httpResponse = client.execute(httpUriRequest);
            logger.debug("Status Code:" + httpResponse.getStatusLine().getStatusCode());
            // 获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();
            entity.getContentType();
            // 判断响应实体是否为空
            if (entity != null) {
                System.out.println(EntityUtils.toString(entity));
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
    }
}
