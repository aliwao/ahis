package cn.com.liandisys.ahis.webapp.dto;

import java.sql.Timestamp;

public class PersonPaymentInfoEntity {

	private long userID;
	private String diagnosisCardNo;
	private String socailSecurityCardNo;
	private String medicareCardNo;
	private String healthCardNo;
	private Timestamp loginTime;
	private String loginUser;
	private Timestamp updateTime;
	private String updateUser;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getDiagnosisCardNo() {
		return diagnosisCardNo;
	}

	public void setDiagnosisCardNo(String diagnosisCardNo) {
		this.diagnosisCardNo = diagnosisCardNo;
	}

	public String getSocailSecurityCardNo() {
		return socailSecurityCardNo;
	}

	public void setSocailSecurityCardNo(String socailSecurityCardNo) {
		this.socailSecurityCardNo = socailSecurityCardNo;
	}

	public String getMedicareCardNo() {
		return medicareCardNo;
	}

	public void setMedicareCardNo(String medicareCardNo) {
		this.medicareCardNo = medicareCardNo;
	}

	public String getHealthCardNo() {
		return healthCardNo;
	}

	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
