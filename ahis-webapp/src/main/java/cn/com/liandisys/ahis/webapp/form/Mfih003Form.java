package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;

/**
 * 住院详细页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfih003Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6634541905186868124L;

	/** 状态Flag 0:未入院，1:已在院，2：已出院 */
	private String statusFlg;
	/** 住院单号 */
	private String stayNo;
	/** 用户name */
	private String userName;
	/** 医院名称 */
	private String hospitalName;
	/** 医生姓名 */
	private String doctorName;
	/** 护士姓名 */
	private String nurseName;
	/** 科室name */
	private String deptName;
	/** 诊断信息 */
	private String diagnoseInfo;
	/** 病区 */
	private String area;
	/** 病床 */
	private String bed;
	/** 入院时间 */
	private String inDate;
	/** 出院时间 */
	private String outDate;
	/** 住院天数 */
	private String stayCount;
	/** 住院总费用 */
	private String totalFee;
	/** 住院押金总额 */
	private String totalDeposit;
	/** 住院押金余额 */
	private String balance;

	public String getStatusFlg() {
		return statusFlg;
	}

	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}

	public String getStayNo() {
		return stayNo;
	}

	public void setStayNo(String stayNo) {
		this.stayNo = stayNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDiagnoseInfo() {
		return diagnoseInfo;
	}

	public void setDiagnoseInfo(String diagnoseInfo) {
		this.diagnoseInfo = diagnoseInfo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getStayCount() {
		return stayCount;
	}

	public void setStayCount(String stayCount) {
		this.stayCount = stayCount;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTotalDeposit() {
		return totalDeposit;
	}

	public void setTotalDeposit(String totalDeposit) {
		this.totalDeposit = totalDeposit;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
