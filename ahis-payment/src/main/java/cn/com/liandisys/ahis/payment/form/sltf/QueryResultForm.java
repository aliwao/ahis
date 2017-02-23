package cn.com.liandisys.ahis.payment.form.sltf;

public class QueryResultForm extends BaseResultForm {
    // 商户编号
    private String corpid;
    // 商户收费项目编号
    private String itemid;
    // 付费编号
    private String corpuserid;
    // 商户订单号
    private String orderid;
    // 商户订单金额
    private String orderfee;
    // 商户订单提交时间
    private String orderdatetime;
    // 支付订单号
    private String payorderid;
    // 订单实际支付金额
    private String payfee;
    // 手续费
    private String ratefee;
    // 支付时间
    private String paydatetime;
    // 保留字段
    private String reserved;
    // 支付结果编码
    private String payresultcode;
    // 支付结果描述
    private String payresultmsg;

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

    public String getCorpuserid() {
        return corpuserid;
    }

    public void setCorpuserid(String corpuserid) {
        this.corpuserid = corpuserid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderfee() {
        return orderfee;
    }

    public void setOrderfee(String orderfee) {
        this.orderfee = orderfee;
    }

    public String getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(String orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public String getPayorderid() {
        return payorderid;
    }

    public void setPayorderid(String payorderid) {
        this.payorderid = payorderid;
    }

    public String getPayfee() {
        return payfee;
    }

    public void setPayfee(String payfee) {
        this.payfee = payfee;
    }

    public String getRatefee() {
        return ratefee;
    }

    public void setRatefee(String ratefee) {
        this.ratefee = ratefee;
    }

    public String getPaydatetime() {
        return paydatetime;
    }

    public void setPaydatetime(String paydatetime) {
        this.paydatetime = paydatetime;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getPayresultcode() {
        return payresultcode;
    }

    public void setPayresultcode(String payresultcode) {
        this.payresultcode = payresultcode;
    }

    public String getPayresultmsg() {
        return payresultmsg;
    }

    public void setPayresultmsg(String payresultmsg) {
        this.payresultmsg = payresultmsg;
    }
}
