package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 就诊卡绑定页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mpst005Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8440124773676362804L;

	/** 就诊卡号 */
	private String patCardNo;

	/** 验证码 */
	private String identifyingCode;

	/** 是否存在绑定的就诊卡 */
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
