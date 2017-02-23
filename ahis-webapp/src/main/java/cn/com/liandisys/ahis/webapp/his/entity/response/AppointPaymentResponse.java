package cn.com.liandisys.ahis.webapp.his.entity.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class AppointPaymentResponse extends BaseResponse {
	private String receiptNum;
	private String clinic_code;
	private String serialNum;
	private String visitPosition;

	public String getReceiptNum() {
		return receiptNum;
	}

	public void setReceiptNum(String receiptNum) {
		this.receiptNum = receiptNum;
	}

	public String getClinic_code() {
		return clinic_code;
	}

	public void setClinic_code(String clinic_code) {
		this.clinic_code = clinic_code;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getVisitPosition() {
		return visitPosition;
	}

	public void setVisitPosition(String visitPosition) {
		this.visitPosition = visitPosition;
	}
}
