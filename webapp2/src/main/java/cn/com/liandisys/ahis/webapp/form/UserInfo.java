package cn.com.liandisys.ahis.webapp.form;

import java.io.Serializable;

public class UserInfo implements Serializable {

	private static final long serialVersionUID = 4478869554670279031L;
	
	private String telNo;
	private String passWord;
	private int age;
	private String address;

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
