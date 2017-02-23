package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class InspResultListSereachRequest extends BaseRequest {

	// 诊疗卡类型
	private String patCardType;
	// 诊疗卡号
	private String patCardNo;
	// 开始日期
	private String beginDate;
	// 结束日期
	private String endDate;

	public String getPatCardType() {
		return patCardType;
	}

	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
