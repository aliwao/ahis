package cn.com.liandisys.ahis.webapp.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

public class Mplg003Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6163606064923668039L;

	/**
	 * 头像
	 */
	private MultipartFile portrait;

	/**
	 * 姓名
	 */
	private String username;

	/**
	 * 身份证号码
	 */
	private String identityCardNo;

	/**
	 * 出生日期
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;

	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 居住地址
	 */
	private String address;
	
	/**
	 * 职业
	 */
	private String occupation;

	public MultipartFile getPortrait() {
		return portrait;
	}

	public String getUsername() {
		return username;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
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

	public void setPortrait(MultipartFile portrait) {
		this.portrait = portrait;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
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
