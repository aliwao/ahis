package cn.com.liandisys.ahis.mock.entity.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class AppointPaymentResponse extends BaseResponse {
	private String receiptNum;
	private String clinic_code;
	private String serialNum;
	private String visitPosition;

	@XmlElement
	public String getReceiptNum() {
		return receiptNum;
	}

	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
	}

	@XmlElement
	public String getClinic_code() {
		return clinic_code;
	}

	public void setClinic_code(String clinic_code) {
		this.clinic_code = clinic_code;
	}

	@XmlElement
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@XmlElement
	public String getVisitPosition() {
		return visitPosition;
	}

	public void setVisitPosition(String visitPosition) {
		this.visitPosition = visitPosition;
	}
}
