package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 添加银行卡页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mpst008Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6257453173268270548L;

	/** 用户ID */
	private String userId;

	/** 持卡人姓名 */
	private String ownCardName;

	/** 证件号码 */
	private String idCardNo;

	/** 银行卡号 */
	private String bankCardNo;

	/** 银行 */
	private String bank;

	/** 银行卡类型 */
	private String bankCardType;

	/** 手机号 */
	private String phoneNo;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOwnCardName() {
		return ownCardName;
	}

	public void setOwnCardName(String ownCardName) {
		this.ownCardName = ownCardName;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankCardType() {
		return bankCardType;
	}

	public void setBankCardType(String bankCardType) {
		this.bankCardType = bankCardType;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
