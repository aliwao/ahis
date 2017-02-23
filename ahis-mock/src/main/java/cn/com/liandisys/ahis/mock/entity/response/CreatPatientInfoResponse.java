package cn.com.liandisys.ahis.mock.entity.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class CreatPatientInfoResponse extends BaseResponse {
	/**
	 * 诊疗卡类型
	 */
	private String patCardType;
	/**
	 * 诊疗卡号码
	 */
	private String patCardNo;

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
}
