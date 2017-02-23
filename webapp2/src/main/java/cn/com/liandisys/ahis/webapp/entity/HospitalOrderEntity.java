package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class HospitalOrderEntity implements Serializable {

	private static final long serialVersionUID = 4975329640243881062L;

	private int userId;
	private int hisOrdNum;
	private String payName;
	private String deptCode;
	private String deptName;
	private String doctorCode;
	private String doctorName;
	private double totalAmt;
	private double medInsAmt;
	private double selfAmt;
	private String scheduleDate;
	private String timeFlag;
	private String payTime;

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

	public void setSelfAmt(double selfAmt) {
		this.selfAmt = selfAmt;
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

	/**
	 * 支付时间
	 */
	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

}
