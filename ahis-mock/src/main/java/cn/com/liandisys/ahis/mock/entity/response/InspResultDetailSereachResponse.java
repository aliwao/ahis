package cn.com.liandisys.ahis.mock.entity.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class InspResultDetailSereachResponse extends BaseResponse {

	private String checkId;
	private String checkName;
	private String deptName;
	private String doctorName;
	private String reportTime;
	private String checkPart;
	private String checkMethod;
	private String checkSituation;
	private String option;
	private String advice;

	@XmlElement
	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

	@XmlElement
	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
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
	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	@XmlElement
	public String getCheckPart() {
		return checkPart;
	}

	public void setCheckPart(String checkPart) {
		this.checkPart = checkPart;
	}

	@XmlElement
	public String getCheckMethod() {
		return checkMethod;
	}

	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	@XmlElement
	public String getCheckSituation() {
		return checkSituation;
	}

	public void setCheckSituation(String checkSituation) {
		this.checkSituation = checkSituation;
	}

	@XmlElement
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@XmlElement
	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

}
