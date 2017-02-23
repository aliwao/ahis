package cn.com.liandisys.common.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

public class AhisHttpClientConfig {

    private String encode;
    private int soTimeout;
    private String uri;
    private HttpMethod method;
    private String contentType;
    private String accept;

    public AhisHttpClientConfig() {
        this.encode = "UTF-8";
        this.accept = MediaType.TEXT_XML_VALUE;
        this.contentType = MediaType.APPLICATION_FORM_URLENCODED_VALUE;
        this.method = HttpMethod.POST;
        this.soTimeout = 60;
    }

    // private String params;
    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public void setSoTimeout(int soTimeout) {
        this.soTimeout = soTimeout;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

}
