package cn.com.liandisys.ahis.mock.form.payment.sltf;

public class QueryForm {
    // 接口版本号
    private String version;
    // 字符集
    private String charset;
    // 合作平台编号
    private String systemid;
    // 商户编号
    private String corpid;
    // 业务编号
    private String itemid;
    // 消息流水号
    private String msgseqno;
    // 付费编号
    private String corpuserid;
    // 付费名称
    private String corpusername;
    // 商户订单号
    private String orderid;
    // 商户订单提交时间
    private String orderdatetime;
    // 保留字段
    private String reserved;
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

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getMsgseqno() {
        return msgseqno;
    }

    public void setMsgseqno(String msgseqno) {
        this.msgseqno = msgseqno;
    }

    public String getCorpuserid() {
        return corpuserid;
    }

    public void setCorpuserid(String corpuserid) {
        this.corpuserid = corpuserid;
    }

    public String getCorpusername() {
        return corpusername;
    }

    public void setCorpusername(String corpusername) {
        this.corpusername = corpusername;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(String orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getSignmsg() {
        return signmsg;
    }

    public void setSignmsg(String signmsg) {
        this.signmsg = signmsg;
    }

}
