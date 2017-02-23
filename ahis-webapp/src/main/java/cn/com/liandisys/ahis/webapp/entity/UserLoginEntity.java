package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class UserLoginEntity implements Serializable {

	private static final long serialVersionUID = 4975329640243881062L;

	private int userID;
	private String password;
	private String mobileNo;
	private String validFlag;
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

}
