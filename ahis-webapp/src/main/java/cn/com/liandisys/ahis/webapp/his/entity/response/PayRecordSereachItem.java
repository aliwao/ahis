package cn.com.liandisys.ahis.webapp.his.entity.response;

public class PayRecordSereachItem {

	private int hisOrdNum;
	private String payName;
	private String deptName;
	private String doctorName;
	private double totalAmt;
	private double medInsAmt;
	private double selfAmt;

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
}
