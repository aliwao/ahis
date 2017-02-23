package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.util.Date;

public class PaymentRecordEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3903015338519177562L;

	private String paymentNo;
	private String paymentRefType;
	private String hisOrdNum;
	private long userID;
	private String departmentName;
	private String doctorName;
	private String paymentName;
	private double orderFee;
	private double payFee;
	private Date orderDateTime;
	private double medicalInsuranceAmount;
	private double medicalselfAmount;
	private Date paidDate;
	private String paidState;
	private String orderType;
	private String paymentNotice;

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

	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
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

	public double getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(double orderFee) {
		this.orderFee = orderFee;
	}

	public double getPayFee() {
		return payFee;
	}

	public void setPayFee(double payFee) {
		this.payFee = payFee;
	}

	public Date getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(Date orderDateTime) {
		this.orderDateTime = orderDateTime;
	}

	public double getMedicalInsuranceAmount() {
		return medicalInsuranceAmount;
	}

	public void setMedicalInsuranceAmount(double medicalInsuranceAmount) {
		this.medicalInsuranceAmount = medicalInsuranceAmount;
	}

	public double getMedicalselfAmount() {
		return medicalselfAmount;
	}

	public void setMedicalselfAmount(double medicalselfAmount) {
		this.medicalselfAmount = medicalselfAmount;
	}

	public Date getPaidDate() {
		return paidDate;
	}

	public void setPaidDate(Date paidDate) {
		this.paidDate = paidDate;
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

}
