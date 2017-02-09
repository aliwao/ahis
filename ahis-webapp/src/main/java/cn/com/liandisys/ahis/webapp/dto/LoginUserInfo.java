package cn.com.liandisys.ahis.webapp.dto;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisDto;

public class LoginUserInfo extends AbstractAhisDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7440063525542705103L;

	private int userID;
	private String password;
	private String name;
	private String mobileNo;
	private String isEnabled;
	/** 身份证号 */
	private String shenfenzhenghao;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(String isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getShenfenzhenghao() {
		return shenfenzhenghao;
	}

	public void setShenfenzhenghao(String shenfenzhenghao) {
		this.shenfenzhenghao = shenfenzhenghao;
	}
}
