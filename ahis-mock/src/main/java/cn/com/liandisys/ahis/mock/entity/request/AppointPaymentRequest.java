package cn.com.liandisys.ahis.mock.entity.request;

import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;

@XmlRootElement(name = "Request")
public class AppointPaymentRequest extends BaseRequest {
	/**
	 * 平台订单号
	 */
	private String hisOrdNum;
	/**
	 * 医院订单号
	 */
	private String psOrdNum;
	/**
	 * 支付方式
	 */
	private String payMode;
	/**
	 * 支付金额
	 */
	private String payAmt;
	/**
	 * 收单机构流水账号
	 */
	private String agtOrdNum;
	/**
	 * 支付时间
	 */
	private String payTime;

	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	public String getPsOrdNum() {
		return psOrdNum;
	}

	public void setPsOrdNum(String psOrdNum) {
		this.psOrdNum = psOrdNum;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	public String getAgtOrdNum() {
		return agtOrdNum;
	}

	public void setAgtOrdNum(String agtOrdNum) {
		this.agtOrdNum = agtOrdNum;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
}
