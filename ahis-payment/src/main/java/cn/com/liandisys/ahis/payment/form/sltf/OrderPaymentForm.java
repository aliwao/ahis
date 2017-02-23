package cn.com.liandisys.ahis.payment.form.sltf;

import java.math.BigDecimal;

public class OrderPaymentForm extends BaseForm {

    // 业务类型
    private String businesstype;
    // 商联的支付方式类型
    private String paymentmode;
    // 商户编号
    private String corpid;
    // 业务编号
    private String itemid;
    // 消息流水号
    private String msgseqno;
    // 用户编号
    private String uid;
    // 付费编号
    private String corpuserid;
    // 付费名称
    private String corpusername;
    // 商户订单号
    private String orderid;
    // 商户订单金额
    private BigDecimal orderfee;
    // 订单实际支付金额
    private BigDecimal payfee;
    // 商户订单提交时间
    private String orderdatetime;
    // 账户号码
    private String accountNumber;
    // 银行预留手机号
    private String customphone;
    // 前台回调URL
    private String fronturl;
    // 合作平台服务器接收处理结果的地址
    private String receiveurl;
    // 商户自定义信息
    private String note;
    // 客户其他信息
    private String custominfo;
    // 保留字段
    private String reserved;

    public String getBusinesstype() {
        return businesstype;
    }

    public void setBusinesstype(String businesstype) {
        this.businesstype = businesstype;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public BigDecimal getOrderfee() {
        return orderfee;
    }

    public void setOrderfee(BigDecimal orderfee) {
        this.orderfee = orderfee;
    }

    public BigDecimal getPayfee() {
        return payfee;
    }

    public void setPayfee(BigDecimal payfee) {
        this.payfee = payfee;
    }

    public String getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(String orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomphone() {
        return customphone;
    }

    public void setCustomphone(String customphone) {
        this.customphone = customphone;
    }

    public String getFronturl() {
        return fronturl;
    }

    public void setFronturl(String fronturl) {
        this.fronturl = fronturl;
    }

    public String getReceiveurl() {
        return receiveurl;
    }

    public void setReceiveurl(String receiveurl) {
        this.receiveurl = receiveurl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCustominfo() {
        return custominfo;
    }

    public void setCustominfo(String custominfo) {
        this.custominfo = custominfo;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }
}
