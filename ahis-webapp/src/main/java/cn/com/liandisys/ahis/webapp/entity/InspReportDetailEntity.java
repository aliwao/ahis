package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.util.List;

import cn.com.liandisys.ahis.webapp.his.entity.response.InspReportDetailSereachItem;

public class InspReportDetailEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 251366467988876323L;

	// 检查ID
	private String inspectId;
	// 检查名称
	private String inspectName;
	// 送检科室
	private String deptName;
	// 送检医生
	private String doctorName;
	// 送检时间
	private String inspectTime;
	// 报告时间
	private String reportTime;
	// 报告详情list
	private List<InspReportDetailSereachItem> inspReportDetailList;

	public String getInspectId() {
		return inspectId;
	}

	public void setInspectId(String inspectId) {
		this.inspectId = inspectId;
	}

	public String getInspectName() {
		return inspectName;
	}

	public void setInspectName(String inspectName) {
		this.inspectName = inspectName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getInspectTime() {
		return inspectTime;
	}

	public void setInspectTime(String inspectTime) {
		this.inspectTime = inspectTime;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public List<InspReportDetailSereachItem> getInspReportDetailList() {
		return inspReportDetailList;
	}

	public void setInspReportDetailList(List<InspReportDetailSereachItem> inspReportDetailList) {
		this.inspReportDetailList = inspReportDetailList;
	}

}
