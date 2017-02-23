package cn.com.liandisys.ahis.webapp.his.entity.request.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class PhyExamReportListBaseHisRequest extends AbstractHisRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2449871248260738238L;
	// 体检人姓名
	private String patName;
	// 体检号
	private String patCardNo;
	// 开始日期
	private String beginDate;
	// 结束日期
	private String endDate;

	@XmlElement
	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	@XmlElement
	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
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
