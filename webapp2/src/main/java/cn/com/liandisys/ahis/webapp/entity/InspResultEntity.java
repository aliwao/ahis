package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class InspResultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5686545641971096564L;

	// 检查ID
	private String checkId;
	// 检查名称
	private String checkName;
	// 检查时间
	private String checkTime;
	// 报告状态
	private String checkStatus;
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

	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
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
