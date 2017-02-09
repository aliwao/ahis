package cn.com.liandisys.ahis.mock.entity.request;

import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;

@XmlRootElement(name = "Request")
public class PhyExamReportListSereachRequest extends BaseRequest {

	// 体检人姓名
	private String patName;
	// 体检号
	private String patCardNo;
	// 开始日期
	private String beginDate;
	// 结束日期
	private String endDate;

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
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
