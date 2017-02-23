package cn.com.liandisys.ahis.webapp.dto;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisDto;

public class LoginUserInfo extends AbstractAhisDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7440063525542705103L;

	private int userID;
	private String password;
	private String mobileNo;
	private String validFlag;
	
	/** 身份证号 */
	private String identityCardNo;
	/** 姓名 */
	private String fullName;
    /** 头像 */
    private byte[] portrait;

	public int getUserID() {
		return userID;
	}

	public String getPassword() {
		return password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getValidFlag() {
		return validFlag;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setValidFlag(String validFlag) {
		this.validFlag = validFlag;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public byte[] getPortrait() {
		return portrait;
	}

	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
	}

}
