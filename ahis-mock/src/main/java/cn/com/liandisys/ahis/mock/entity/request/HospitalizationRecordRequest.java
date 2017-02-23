package cn.com.liandisys.ahis.mock.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;

@XmlRootElement(name = "Request")
public class HospitalizationRecordRequest extends BaseRequest {
	/** 诊疗卡类型 */
	private String patCardType;
	/** 诊疗卡号 */
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
