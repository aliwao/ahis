package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 医保卡绑定页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mpst004Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -406802926482447014L;

	/** 医保卡号 */
	private String patCardNo;

	/** 验证码 */
	private String identifyingCode;

	/** 是否存在绑定的医保卡 */
	private String existCard;

	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	public String getIdentifyingCode() {
		return identifyingCode;
	}

	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}

	public String getExistCard() {
		return existCard;
	}

	public void setExistCard(String existCard) {
		this.existCard = existCard;
	}

}
