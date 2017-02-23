package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

public class Mfrg004Form extends AbstractAhisForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5373486756800293963L;

	private int userID;
	private String userName;
	private String deptCode;
	private String deptName;
	private String doctorCode;
	private String doctorName;
	private String reserveDate;
	private String regFee;
	private String timeFlag;
	private boolean isExpert;
	private String detailedTime;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getRegFee() {
		return regFee;
	}

	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

	public String getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	public boolean getIsExpert() {
		return isExpert;
	}

	public void setIsExpert(boolean isExpert) {
		this.isExpert = isExpert;
	}

	public String getDetailedTime() {
		return detailedTime;
	}

	public void setDetailedTime(String detailedTime) {
		this.detailedTime = detailedTime;
	}


}
