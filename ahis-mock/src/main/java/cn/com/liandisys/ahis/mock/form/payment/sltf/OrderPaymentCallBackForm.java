package cn.com.liandisys.ahis.mock.form.payment.sltf;

import java.math.BigDecimal;

public class OrderPaymentCallBackForm {

	// 接口版本号
	private String version;
	// 字符集
	private String charset;
	// 合作平台编号
	private String systemid;
	// 消息流水号
	private String msgseqno;
	// 付费编号
	private String uid;
	// 商户订单号
	private String orderid;
	// 商户订单金额
	private BigDecimal orderfee;
	// 客户其他信息
	private String custominfo;
	// 保留字段
	private String reserved;
	// 处理结果编码
	private String resultcode;
	// 处理结果描述
	private String resultmsg;
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

	public BigDecimal getOrderfee() {
		return orderfee;
	}

	public void setOrderfee(BigDecimal orderfee) {
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

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getResultmsg() {
		return resultmsg;
	}

	public void setResultmsg(String resultmsg) {
		this.resultmsg = resultmsg;
	}

	public String getSignmsg() {
		return signmsg;
	}

	public void setSignmsg(String signmsg) {
		this.signmsg = signmsg;
	}

}
