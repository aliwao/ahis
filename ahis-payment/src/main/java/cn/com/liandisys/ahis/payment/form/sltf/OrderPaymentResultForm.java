package cn.com.liandisys.ahis.payment.form.sltf;

public class OrderPaymentResultForm extends BaseResultForm {
    // 消息流水号
    private String msgseqno;
    // 付费编号
    private String uid;
    // 商户订单号
    private String orderid;
    // 商户订单金额
    private String orderfee;
    // 客户其他信息
    private String custominfo;
    // 保留字段
    private String reserved;

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
