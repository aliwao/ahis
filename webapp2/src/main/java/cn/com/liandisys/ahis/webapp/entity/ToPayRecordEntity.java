package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class ToPayRecordEntity implements Serializable{

	private static final long serialVersionUID = 4975329640243881062L;

	private String resultCode;
	private String resultMessage;
	private int hisOrdNum;
	private String payName;
	private String deptName;
	private String doctorName;
	private double totalAmt;
	private double medInsAmt;
	private double selfAmt;

	/**
	 * 交易结果代码
	 */
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * 错误消息
	 */
	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	/**
	 * 医院订单号
	 */
	public int getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(int hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}
	
	/**
	 * 缴费项名称
	 */
	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}
	
	/**
	 * 接诊科室名称
	 */
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	 * 接诊医生姓名
	 */
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	/**
	 * 缴费总额
	 */
	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	/**
	 * 医保部分金额
	 */
	public double getmMedInsAmt() {
		return medInsAmt;
	}

	public void setMedInsAmt(double medInsAmt) {
		this.medInsAmt = medInsAmt;
	}
	
	/**
	 * 自费部分金额
	 */
	public double getSelfAmt() {
		return selfAmt;
	}

	public void setSelfAmt(Double selfAmt) {
		this.selfAmt = selfAmt;
	}
}
