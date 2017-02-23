package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfoEntity implements Serializable {
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8413503045362807025L;

	/**
    * 用户ID
    */
    private int userID;

    /**
    * 身份证号
    */
    private String identityCardNo;

    /**
    * 姓名
    */
    private String fullName;

    /**
     * 头像
     */
    private byte[] portrait;

    /**
    * 出生日期
    */
    private Date birthDate;

    /**
    * 性别
    */
    private String sex;

    /**
    * 住址
    */
    private String address;

    /**
    * 职业
    */
    private String occupation;

	public int getUserID() {
		return userID;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public String getFullName() {
		return fullName;
	}

	public byte[] getPortrait() {
		return portrait;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setPortrait(byte[] portrait) {
		this.portrait = portrait;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

}