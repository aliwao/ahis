package cn.com.liandisys.ahis.payment.form.sltf;

public class BaseForm {
    // 接口版本号
    private String version;
    // 字符集
    private String charset;
    // 合作平台编号
    private String systemid;
    // 签名字符串
    private String signmsg;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    public String getSignmsg() {
        return signmsg;
    }

    public void setSignmsg(String signmsg) {
        this.signmsg = signmsg;
    }

}
