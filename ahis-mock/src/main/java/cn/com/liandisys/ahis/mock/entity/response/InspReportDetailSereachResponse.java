package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class InspReportDetailSereachResponse extends BaseResponse {

	// 检验ID
	private String inspectId;
	// 检验名称
	private String inspectName;
	// 送检科室
	private String deptName;
	// 送检医生
	private String doctorName;
	// 送检时间
	private String inspectTime;
	// 报告时间
	private String reportTime;

	private List<InspReportDetailSereachItem> itemList;

	@XmlElement
	public String getInspectId() {
		return inspectId;
	}

	public void setInspectId(String inspectId) {
		this.inspectId = inspectId;
	}

	@XmlElement
	public String getInspectName() {
		return inspectName;
	}

	public void setInspectName(String inspectName) {
		this.inspectName = inspectName;
	}

	@XmlElement
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@XmlElement
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@XmlElement
	public String getInspectTime() {
		return inspectTime;
	}

	public void setInspectTime(String inspectTime) {
		this.inspectTime = inspectTime;
	}

	@XmlElement
	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	@XmlElement(name = "item")
	public List<InspReportDetailSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<InspReportDetailSereachItem> itemList) {
		this.itemList = itemList;
	}
}
