package cn.com.liandisys.ahis.webapp.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

public class Mplg003Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6163606064923668039L;

	/**
	 * 头像 TODO
	 */
	private String toupic;

	/**
	 * 姓名
	 */
	private String username;

	/**
	 * 身份证号码
	 */
	private String sfzhao;

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
	private String zhiye;

	public String getToupic() {
		return toupic;
	}

	public void setToupic(String toupic) {
		this.toupic = toupic;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSfzhao() {
		return sfzhao;
	}

	public void setSfzhao(String sfzhao) {
		this.sfzhao = sfzhao;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZhiye() {
		return zhiye;
	}

	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}
}
