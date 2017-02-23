package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

public class Mplg002Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4908969776841193072L;

	/** 手机号码 */
	private String telno;

	/** 姓名 */
	private String username;

	/** 身份证号码 */
	private String sfzhaoma;

	/** 密码 */
	private String password;

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSfzhaoma() {
		return sfzhaoma;
	}

	public void setSfzhaoma(String sfzhaoma) {
		this.sfzhaoma = sfzhaoma;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
