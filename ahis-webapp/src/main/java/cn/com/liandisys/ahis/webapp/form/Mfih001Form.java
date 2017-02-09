package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 入院缴费页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfih001Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3194699392237683934L;

	/** 住院单号 */
	private String stayNo;
	/** 用户name */
	private String userName;
	/** 医院名称 */
	private String hospitalName;
	/** 医生姓名 */
	private String doctorName;
	/** 科室name */
	private String deptName;
	/** 诊断信息 */
	private String diagnoseInfo;
	/** 病区 */
	private String area;
	/** 入院时间 */
	private String inDate;
	/** 预缴费 */
	private String advancedPay;

	public String getStayNo() {
		return stayNo;
	}

	public void setStayNoD(String stayNo) {
		this.stayNo = stayNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDiagnoseInfo() {
		return diagnoseInfo;
	}

	public void setDiagnoseInfo(String diagnoseInfo) {
		this.diagnoseInfo = diagnoseInfo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getAdvancedPay() {
		return advancedPay;
	}

	public void setAdvancedPay(String advancedPay) {
		this.advancedPay = advancedPay;
	}

}
