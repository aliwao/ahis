package cn.com.liandisys.ahis.mock.entity;

import javax.xml.bind.annotation.XmlElement;

public class BaseResponse {
	private String resultCode;
	private String resultMessage;

	@XmlElement
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	@XmlElement
	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
