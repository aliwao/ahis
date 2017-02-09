package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class HospitalOrderEntity implements Serializable {

	private static final long serialVersionUID = 4975329640243881062L;

	private int userId;
	private int hisOrdNum;
	private String payName;
	private String deptName;
	private String doctorName;
	private double totalAmt;
	private double medInsAmt;
	private double selfAmt;
	private double totalAmt_all;
	private double totalAmt_paid;
	private double totalAmt_pay;
	private double medIns_all;
	private double medIns_paid;
	private double medIns_pay;
	private double selfAmt_all;
	private double selfAmt_paid;
	private double selfAmt_pay;
	private String scheduleDate;
	private String timeFlag;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	public double getMedInsAmt() {
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

	/**
	 * 总费用全金额
	 */
	public double getTotalAmt_all() {
		return totalAmt_all;
	}

	public void setTotalAmt_all(double totalAmt_all) {
		this.totalAmt_all = totalAmt_all;
	}

	/**
	 * 总费用已支付
	 */
	public double getTotalAmt_paid() {
		return totalAmt_paid;
	}

	public void setTotalAmt_paid(double totalAmt_paid) {
		this.totalAmt_paid = totalAmt_paid;
	}

	/**
	 * 总费用待支付
	 */
	public double getTotalAmt_pay() {
		return totalAmt_pay;
	}

	public void setTotalAmt_pay(double totalAmt_pay) {
		this.totalAmt_pay = totalAmt_pay;
	}

	/**
	 * 医保部分全金额
	 */
	public double getMedIns_all() {
		return medIns_all;
	}

	public void setMedIns_all(double medIns_all) {
		this.medIns_all = medIns_all;
	}

	/**
	 * 医保部分已支付
	 */
	public double getMedIns_paid() {
		return medIns_paid;
	}

	public void setMedIns_paid(double medIns_paid) {
		this.medIns_paid = medIns_paid;
	}

	/**
	 * 医保部分待支付
	 */
	public double getMedIns_pay() {
		return medIns_pay;
	}

	public void setMedIns_pay(double medIns_pay) {
		this.medIns_pay = medIns_pay;
	}

	/**
	 * 自费部分全金额
	 */
	public double getSelfAmt_all() {
		return selfAmt_all;
	}

	public void setSelfAmt_all(Double selfAmt_all) {
		this.selfAmt_all = selfAmt_all;
	}

	/**
	 * 自费部分已支付
	 */
	public double getSelfAmt_paid() {
		return selfAmt_paid;
	}

	public void setSelfAmt_paid(Double selfAmt_paid) {
		this.selfAmt_paid = selfAmt_paid;
	}

	/**
	 * 自费部分待支付
	 */
	public double getSelfAmt_pay() {
		return selfAmt_pay;
	}

	public void setSelfAmt_pay(Double selfAmt_pay) {
		this.selfAmt_pay = selfAmt_pay;
	}

	/**
	 * 就诊日期
	 */

	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	/**
	 * 就诊时段
	 */

	public String getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}
}
