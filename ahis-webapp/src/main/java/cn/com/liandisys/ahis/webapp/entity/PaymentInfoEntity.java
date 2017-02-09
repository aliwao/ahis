package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

/**
 * 缴费情报entity
 */
public class PaymentInfoEntity implements Serializable{

	private static final long serialVersionUID = 4975329640243881062L;

	private int userID;
	private int hospitalID;
	private int pararentID;
	private int departID;
	private int paymentID;
	private String visitTime;
	private String paymentCompletionTime;
	private String paymentCompletionFlg;
	private String comment;

	/**
	 * 用户ID
	 */
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * 医院ID
	 */
	public int getHospitalID() {
		return hospitalID;
	}

	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}
	
	/**
	 * 上级ID
	 */
	public int getPararentID() {
		return pararentID;
	}

	public void setPararentID(int pararentID) {
		this.pararentID = pararentID;
	}
	
	/**
	 * 科室ID
	 */
	public int getDepartID() {
		return departID;
	}

	public void setDepartID(int departID) {
		this.departID = departID;
	}
	
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
	 * 就诊时间
	 */
	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}
	
	/**
	 * 缴费完成时间
	 */
	public String getPaymentCompletionTime() {
		return paymentCompletionTime;
	}

	public void setPaymentCompletionTime(String paymentCompletionTime) {
		this.paymentCompletionTime = paymentCompletionTime;
	}
	
	/**
	 * 缴费完成flag
	 */
	public String getPaymentCompletionFlg() {
		return paymentCompletionFlg;
	}

	public void setPaymentCompletionFlg(String paymentCompletionFlg) {
		this.paymentCompletionFlg = paymentCompletionFlg;
	}
	
	/**
	 * 说明
	 */
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
