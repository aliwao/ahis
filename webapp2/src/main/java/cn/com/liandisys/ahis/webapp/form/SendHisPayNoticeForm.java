package cn.com.liandisys.ahis.webapp.form;

import java.io.Serializable;

public class SendHisPayNoticeForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -302866544207839628L;

	/**
	 * 缴费单号
	 */
	private String paymentNo;

	/**
	 * 交易结果代码
	 */
	private String resultCode;

	/**
	 * 错误消息
	 */
	private String resultMessage;

	public String getPaymentNo() {
		return paymentNo;
	}


	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
