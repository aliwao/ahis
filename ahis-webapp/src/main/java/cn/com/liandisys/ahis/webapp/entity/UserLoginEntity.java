package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class UserLoginEntity implements Serializable {

	private static final long serialVersionUID = 4975329640243881062L;

	private int userID;
	private String password;
	private String name;
	private String mobileNo;
	private String isEnabled;

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
}
