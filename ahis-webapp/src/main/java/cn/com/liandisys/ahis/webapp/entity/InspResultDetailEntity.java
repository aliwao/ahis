package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class InspResultDetailEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3614730820515124332L;

	// 检查ID
	private String checkId;
	// 检查名称
	private String checkName;
	// 送检科室
	private String deptName;
	// 送检医生
	private String doctorName;
	// 报告时间
	private String reportTime;
	// 检查部位
	private String checkPart;
	// 检查方法
	private String checkMethod;
	// 检查所见
	private String checkSituation;
	// 诊断意见
	private String option;
	// 医嘱项
	private String advice;

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

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getCheckPart() {
		return checkPart;
	}

	public void setCheckPart(String checkPart) {
		this.checkPart = checkPart;
	}

	public String getCheckMethod() {
		return checkMethod;
	}

	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	public String getCheckSituation() {
		return checkSituation;
	}

	public void setCheckSituation(String checkSituation) {
		this.checkSituation = checkSituation;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

}
