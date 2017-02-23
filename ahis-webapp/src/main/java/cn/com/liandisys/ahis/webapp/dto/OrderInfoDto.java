package cn.com.liandisys.ahis.webapp.dto;

import java.sql.Timestamp;

/**
 * 订单Dto。
 * 
 * @author xuyue
 *
 */
public class OrderInfoDto {
	/** 订单流水号 */
	private String orderId;
	/** 订单来源 1.挂号预约缴费 2.住院押金补缴 */
	private String orderRefType;
	/** 订单来源 流水号 */
	private String orderRefSeqNo;
	/** 用户ID */
	private Integer userId;
	/** 商户订单金额 */
	private Double orderFee;
	/** 订单实际支付金额 */
	private Double payFee;
	/** 商户订单提交时间 */
	private Timestamp orderDateTime;
	/** 订单状态 */
	private String orderStatus;
	/** 登录时间 */
	private Timestamp loginTime;
	/** 登录者 */
	private Integer loginUser;
	/** 更新时间 */
	private Timestamp updateTime;
	/** 更新者 */
	private Integer updateUser;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderRefType() {
		return orderRefType;
	}

	public void setOrderRefType(String orderRefType) {
		this.orderRefType = orderRefType;
	}

	public String getOrderRefSeqNo() {
		return orderRefSeqNo;
	}

	public void setOrderRefSeqNo(String orderRefSeqNo) {
		this.orderRefSeqNo = orderRefSeqNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Double getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(Double orderFee) {
		this.orderFee = orderFee;
	}

	public Double getPayFee() {
		return payFee;
	}

	public void setPayFee(Double payFee) {
		this.payFee = payFee;
	}

	public Timestamp getOrderDatetime() {
		return orderDateTime;
	}

	public void setOrderDatetime(Timestamp orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(Integer loginUser) {
		this.loginUser = loginUser;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

}
