package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

/**
 * 住院情报entity
 */
public class PatientsHospitalizedEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7889304211178237490L;
	/** 住院单号 */
	private String stayNo;
	/** 用户ID */
	private int userId;
	/** 医院Code */
	private String hospitalCode;
	/** 科室Code */
	private String deptCode;
	/** 科室Name */
	private String deptName;
	/** 医生Code */
	private String doctorCode;
	/** 医生Name */
	private String doctorName;
	/** 护士Name */
	private String nurseName;
	/** 诊断信息 */
	private String diagnoseInfo;
	/** 病区 */
	private String area;
	/** 病床 */
	private String bed;
	/** 入院时间（星期） */
	private String startDate;
	/** 入院时间 */
	private String inDate;
	/** 出院时间 */
	private String outDate;
	/** 预缴费 */
	private Double advancedPay;
	/** 补缴费 */
	private Double supplementaryPay;
	/** 退费 */
	private Double returnPay;
	/** 总金额 */
	private String totalFee;
	/** 状态Flag 0:未入院，1:已在院，2：已出院 */
	private String statusFlg;
	/** 有效Flag */
	private String validFlg;
	/** 备考 */
	private String commentInfo;

	/**
	 * 住院单号
	 */
	public String getStayNo() {
		return stayNo;
	}

	public void setStayNo(String stayNo) {
		this.stayNo = stayNo;
	}

	/**
	 * 用户ID
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 医院Code
	 */
	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	/**
	 * 科室Code
	 */
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 科室Name
	 */
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 医生Code
	 */
	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	/**
	 * 医生Name
	 */
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * 护士Code
	 */
	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	/**
	 * 诊断信息
	 */
	public String getDiagnoseInfo() {
		return diagnoseInfo;
	}

	public void setDiagnoseInfo(String diagnoseInfo) {
		this.diagnoseInfo = diagnoseInfo;
	}

	/**
	 * 病区
	 */
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 病床
	 */
	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	/**
	 * 入院时间
	 */
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 入院时间
	 */
	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	/**
	 * 出院时间
	 */
	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String inDate) {
		this.outDate = inDate;
	}

	/**
	 * 预缴费
	 */
	public Double getAdvancedPay() {
		return advancedPay;
	}

	public void setAdvancedPay(Double advancedPay) {
		this.advancedPay = advancedPay;
	}

	/**
	 * 补缴费
	 */
	public Double getSupplementaryPay() {
		return supplementaryPay;
	}

	public void setSupplementaryPay(Double supplementaryPay) {
		this.supplementaryPay = supplementaryPay;
	}

	/**
	 * 退费
	 */
	public Double getReturnPay() {
		return returnPay;
	}

	public void setReturnPay(Double returnPay) {
		this.returnPay = returnPay;
	}

	/**
	 * 总金额
	 */
	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	/**
	 * 状态Flag
	 */
	public String getStatusFlg() {
		return statusFlg;
	}

	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}

	/**
	 * 有效Flag
	 */
	public String getValidFlg() {
		return validFlg;
	}

	public void setValidFlg(String validFlg) {
		this.validFlg = validFlg;
	}

	/**
	 * 备考
	 */
	public String getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}
}
