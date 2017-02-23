package cn.com.liandisys.ahis.webapp.dto;

import java.sql.Timestamp;

/**
 * 个人缴费记录Dto。
 * 
 * @author xuyue
 *
 */
public class PaymentRecordDto {
	/** 缴费单号 */
	private String paymentNo;
	/** 缴费来源 1.挂号预约缴费 2.住院押金补缴 3：门诊缴费 */
	private String paymentRefType;
	/** 缴费来源流水号 */
	private Integer hisOrdNum;
	/** 用户ID */
	private Integer userID;
	/** 科室名称 */
	private String departmentName;
	/** 医生名称 */
	private String doctorName;
	/** 缴费项名称 */
	private String paymentName;
	/** 商户订单金额 */
	private Double orderFee;
	/** 实际支付金额 */
	private Double payFee;
	/** 商户订单提交时间 */
	private Timestamp orderDateTime;
	/** 医保部分金额 */
	private Double medicalInsuranceAmount;
	/** 自费部分金额 */
	private Double medicalselfAmount;
	/** 缴费完成日期 */
	private Timestamp paidDate;
	/** 缴费完成状态 */
	private String paidState;
	/** 订单类型 */
	private String orderType;
	/** 支付通知 */
	private String paymentNotice;
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

	public String getPaymentRefType() {
		return paymentRefType;
	}

	public void setPaymentRefType(String paymentRefType) {
		this.paymentRefType = paymentRefType;
	}

	public Integer getUserId() {
		return userID;
	}

	public void setUserId(Integer userID) {
		this.userID = userID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public Double getMedicalInsuranceAmount() {
		return medicalInsuranceAmount;
	}

	public void setMedicalInsuranceAmount(Double medicalInsuranceAmount) {
		this.medicalInsuranceAmount = medicalInsuranceAmount;
	}

	public Double getMedicalselfAmount() {
		return medicalselfAmount;
	}

	public void setMedicalselfAmount(Double medicalselfAmount) {
		this.medicalselfAmount = medicalselfAmount;
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

	public Timestamp getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Timestamp paidDate) {
		this.paidDate = paidDate;
	}

	public Double getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(Double orderFee) {
		this.orderFee = orderFee;
	}

	public String getPaidState() {
		return paidState;
	}

	public void setPaidState(String paidState) {
		this.paidState = paidState;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPaymentNotice() {
		return paymentNotice;
	}

	public void setPaymentNotice(String paymentNotice) {
		this.paymentNotice = paymentNotice;
	}

	public Integer getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(Integer hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
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
