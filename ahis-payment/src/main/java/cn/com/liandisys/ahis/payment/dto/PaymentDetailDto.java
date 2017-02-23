package cn.com.liandisys.ahis.payment.dto;

import java.sql.Timestamp;

/**
 * 支付明细Dto。
 * 
 * @author xuyue
 *
 */
public class PaymentDetailDto {
	/** 缴费单号 */
	private String paymentNo;
	/** 明细SEQ */
	private Long paymentDetailNo;
	/** 商户订单金额 */
	private Double orderFee;
	/** 实际支付金额 */
	private Double payFee;
	/** payType */
	private String payType;
	/** 商户订单提交时间 */
	private Timestamp orderDateTime;
	/** 外部支付结果 */
	private String extPayResultCode;
	/** 外部支付结果详细 */
	private String extPayResultMsg;
	/** 外部支付成功时间 */
	private Timestamp paymentSuccessDateTime;
	/** 外部支付流水号 */
	private String extPaymentId;
	/** 支付状态 */
	private String paymentStatus;
	/** 登录时间 */
	private Timestamp loginTime;
	/** 登录者 */
	private String loginUser;
	/** 更新时间 */
	private Timestamp updateTime;
	/** 更新者 */
	private String updateUser;

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public Long getPaymentDetailNo() {
		return paymentDetailNo;
	}

	public void setPaymentDetailNo(Long paymentDetailNo) {
		this.paymentDetailNo = paymentDetailNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getExtPayResultCode() {
		return extPayResultCode;
	}

	public void setExtPayResultCode(String extPayResultCode) {
		this.extPayResultCode = extPayResultCode;
	}

	public String getExtPayResultMsg() {
		return extPayResultMsg;
	}

	public void setExtPayResultMsg(String extPayResultMsg) {
		this.extPayResultMsg = extPayResultMsg;
	}

	public Timestamp getPaymentSuccessDateTime() {
		return paymentSuccessDateTime;
	}

	public void setPaymentSuccessDateTime(Timestamp paymentSuccessDateTime) {
		this.paymentSuccessDateTime = paymentSuccessDateTime;
	}

	public String getExtPaymentId() {
		return extPaymentId;
	}

	public void setExtPaymentId(String extPaymentId) {
		this.extPaymentId = extPaymentId;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Timestamp getOrderDatetime() {
		return orderDateTime;
	}

	public void setOrderDatetime(Timestamp orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public Double getPayFee() {
		return payFee;
	}

	public void setPayFee(Double payFee) {
		this.payFee = payFee;
	}

	public Double getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(Double orderFee) {
		this.orderFee = orderFee;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}
