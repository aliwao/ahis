package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

/**
 * 缴费详细情报entity
 */
public class PaymentDetailInfoEntity implements Serializable {

	private static final long serialVersionUID = 4975329640243881062L;

	private int paymentID;
	private int bigSubjectID;
	private int smallSubjectID;
	private String count;
	private String totalAmount;
	private String medicalInsurance;
	private String privateTreatment;
	private String medicalInsurancePaid;
	private String privateTreatmentPaid;

	/**
	 * 缴费ID
	 */
	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	/**
	 * 大科目ID
	 */
	public int getBigSubjectID() {
		return bigSubjectID;
	}

	public void setBigSubjectID(int bigSubjectID) {
		this.bigSubjectID = bigSubjectID;
	}

	/**
	 * 小科目ID
	 */
	public int getSmallSubjectID() {
		return smallSubjectID;
	}

	public void setSmallSubjectID(int smallSubjectID) {
		this.smallSubjectID = smallSubjectID;
	}

	/**
	 * 数量
	 */
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * 合计金额
	 */
	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 医保费用
	 */
	public String getMedicalInsurance() {
		return medicalInsurance;
	}

	public void setMedicalInsurance(String medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	/**
	 * 个人自理
	 */
	public String getPrivateTreatment() {
		return privateTreatment;
	}

	public void setPrivateTreatment(String privateTreatment) {
		this.privateTreatment = privateTreatment;
	}

	/**
	 * 医保费用已付金额
	 */
	public String getMedicalInsurancePaid() {
		return medicalInsurancePaid;
	}

	public void setMedicalInsurancePaid(String medicalInsurancePaid) {
		this.medicalInsurancePaid = medicalInsurancePaid;
	}

	/**
	 * 个人自理已付金额
	 */
	public String getPrivateTreatmentPaid() {
		return privateTreatmentPaid;
	}

	public void setPrivateTreatmentPaid(String privateTreatmentPaid) {
		this.privateTreatmentPaid = privateTreatmentPaid;
	}
}
