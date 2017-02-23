package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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

	private String serialNum;

	private String registerType;

	@XmlElement
	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	@XmlElement
	public String getPsOrdNum() {
		return psOrdNum;
	}

	public void setPsOrdNum(String psOrdNum) {
		this.psOrdNum = psOrdNum;
	}

	@XmlElement
	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	@XmlElement
	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	@XmlElement
	public String getAgtOrdNum() {
		return agtOrdNum;
	}

	public void setAgtOrdNum(String agtOrdNum) {
		this.agtOrdNum = agtOrdNum;
	}

	@XmlElement
	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	@XmlElement
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@XmlElement
	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
}
