package cn.com.liandisys.ahis.mock.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;

@XmlRootElement(name = "Request")
public class HospitalizationFeeRequest extends BaseRequest {
	/** 诊疗卡类型 */
	private String patCardType;
	/** 诊疗卡号 */
	private String patCardNo;
	/** 住院号 */
	private String admissionNum;
	/** 清单开始日期 */
	private String beginDate;
	/** 清单结束日期 */
	private String endDate;

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
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	@XmlElement
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
