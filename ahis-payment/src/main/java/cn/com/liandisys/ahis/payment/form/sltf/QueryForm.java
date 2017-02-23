package cn.com.liandisys.ahis.payment.form.sltf;

import java.util.List;

public class QueryForm extends BaseForm {
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
}
