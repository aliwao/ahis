package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class InspReportEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6383739481110472344L;

	// 检验ID
	private String inspectId;
	// 检验名称
	private String inspectName;
	// 检验时间
	private String inspectTime;
	// 报告状态
	private String inspectStatus;
	// 报告时间
	private String reportTime;
	// 审核时间
	private String examTime;
	// 送检科室代码
	private String deptCode;
	// 送检科室名
	private String deptName;
	// 送检医生代码
	private String doctorCode;
	// 送检医生姓名
	private String doctorName;
	// 执行科室代码
	private String exeDeptCode;
	// 执行科室名
	private String exeDeptName;
	// 报告人
	private String reporter;
	// 审核人
	private String auditor;

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

	public String getInspectTime() {
		return inspectTime;
	}

	public void setInspectTime(String inspectTime) {
		this.inspectTime = inspectTime;
	}

	public String getInspectStatus() {
		return inspectStatus;
	}

	public void setInspectStatus(String inspectStatus) {
		this.inspectStatus = inspectStatus;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getExeDeptCode() {
		return exeDeptCode;
	}

	public void setExeDeptCode(String exeDeptCode) {
		this.exeDeptCode = exeDeptCode;
	}

	public String getExeDeptName() {
		return exeDeptName;
	}

	public void setExeDeptName(String exeDeptName) {
		this.exeDeptName = exeDeptName;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

}
