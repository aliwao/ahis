package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 银行卡绑定信息Entity。
 * 
 * @author xuyue
 * @version 1.0
 */
public class BankCardInfoEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 805537286194519798L;

	/** 用户ID */
	private Long userId;

	/** 持卡人姓名 */
	private String ownCardName;

	/** 证件号码（身份证号） */
	private String idCardNo;

	/** 银行卡号 */
	private String bankCardNo;

	/** 银行名称 */
	private String bank;

	/** 银行icon图片路径 */
	private String bankIconImg;

	/** 银行卡类型 */
	private String bankCardType;

	/** 手机号码 */
	private String phoneNo;

	/** 创建时间 */
	private Timestamp insertTimeStamp;


	public Long getUserId() {
		return userId;
    }

	public void setUserId(Long userId) {
		this.userId = userId;
    }

	public String getOwnCardName() {
		return ownCardName;
	}

	public void setOwnCardName(String ownCardName) {
		this.ownCardName = ownCardName;
	}

	public String geIdCardNo() {
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

	public String getBankIconImg() {
		return bankIconImg;
	}

	public void setBankIconImg(String bankIconImg) {
		this.bankIconImg = bankIconImg;
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

	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

}