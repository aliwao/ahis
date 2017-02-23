package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class DepositPayNoticeRequest extends BaseRequest {
	/** 诊疗卡类型 */
	private String patCardType;
	/** 诊疗卡号 */
	private String patCardNo;
	/** 住院号 */
	private String admissionNum;
	/** 平台订单号 */
	private String psOrdNum;
	/** 支付方式 */
	private String payMode;
	/** 补缴押金金额 单位：分 */
	private String payAmt;
	/** 收单机构流水号 */
	private String agtOrdNum;
	/** 支付时间 */
	private String payTime;

	@XmlElement
	public String getPatCardType() {
		return patCardType;
	}

	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	@XmlElement
	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	@XmlElement
	public String getAdmissionNum() {
		return admissionNum;
	}

	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
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
}
