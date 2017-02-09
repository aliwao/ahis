package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 确认缴费Form。
 * 
 */
public class Mfop002Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1494531434742486719L;

	/** 缴费项目 */
	private String payName;
	/** 总计支付 */
	private double totalAmt;
	/** 医保支付 */
	private double medInsAmt;
	/** 个人支付 */
	private double selfAmt;
	
	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}
	public double getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	public double getMedInsAmt() {
		return medInsAmt;
	}

	public void setMedInsAmt(double medInsAmt) {
		this.medInsAmt = medInsAmt;
	}

	public double getSelfAmt() {
		return selfAmt;
	}

	public void setSelfAmt(double selfAmt) {
		this.selfAmt = selfAmt;
	}
}
