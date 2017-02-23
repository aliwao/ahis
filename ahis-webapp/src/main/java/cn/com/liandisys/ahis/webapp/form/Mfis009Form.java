package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 押金补缴页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfis009Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5679483395852232383L;

	/** 用户name */
	private String userName;
	/** 补缴金额 */
	private String payFee;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPayFee() {
		return payFee;
	}

	public void setPayFee(String payFee) {
		this.payFee = payFee;
	}

}
