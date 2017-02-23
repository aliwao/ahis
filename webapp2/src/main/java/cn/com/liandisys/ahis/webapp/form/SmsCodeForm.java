package cn.com.liandisys.ahis.webapp.form;

import java.io.Serializable;

public class SmsCodeForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -302866544207839628L;

	/**
	 * 输入的手机号码
	 */
	private String mobileNo;

	/**
	 * 输入的验证码
	 */
	private String inputVcode;

	/**
	 * 返回的message类型
	 */
	private int msgType;

	/**
	 * 返回的message内容
	 */
	private String message;

	public String getMobileNo() {
		return mobileNo;
	}

	public String getInputVcode() {
		return inputVcode;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setInputVcode(String inputVcode) {
		this.inputVcode = inputVcode;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
