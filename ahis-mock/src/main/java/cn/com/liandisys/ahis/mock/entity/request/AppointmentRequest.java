package cn.com.liandisys.ahis.mock.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;
@XmlRootElement(name = "Request")
public class AppointmentRequest extends BaseRequest {
	/**
	 * 平台订单号
	 */
	private String psOrdNum;
	/**
	 * 科室代码
	 */
	private String deptCode;
	/**
	 * 医生代码
	 */
	private String doctorCode;
	/**
	 * 号源日期
	 */
	private String scheduleDate;
	/**
	 * 时段
	 */
	private String timeFlag;
	/**
	 * 分时开始时间
	 */
	private String beginTime;
	/**
	 * 分时结束时间
	 */
	private String endTime;
	/**
	 * 挂号费
	 */
	private String regFee;
	/**
	 * 患者类型
	 */
	private String patType;
	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 患者性别
	 */
	private String patSex;
	/**
	 * 患者年龄
	 */
	private String patAge;
	/**
	 * 患者证件类型
	 */
	private String patIdType;
	/**
	 * 患者证件号码
	 */
	private String patIdNo;
	/**
	 * 患者诊疗卡类型
	 */
	private String patCardType;
	/**
	 * 患者诊疗卡号码
	 */
	private String patCardNo;
	/**
	 * 手机号码
	 */
	private String patMobile;
	/**
	 * 地址
	 */
	private String patAddress;
	/**
	 * 监护人姓名
	 */
	private String guardName;
	/**
	 * 监护人证件类型
	 */
	private String guardIdType;
	/**
	 * 监护人证件号码
	 */
	private String guardIdNo;

	@XmlElement
	public String getPsOrdNum() {
		return psOrdNum;
	}

	public void setPsOrdNum(String psOrdNum) {
		this.psOrdNum = psOrdNum;
	}

	@XmlElement
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@XmlElement
	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	@XmlElement
	public String getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	@XmlElement
	public String getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	@XmlElement
	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	@XmlElement
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@XmlElement
	public String getRegFee() {
		return regFee;
	}

	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

	@XmlElement
	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
	}

	@XmlElement
	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	@XmlElement
	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	@XmlElement
	public String getPatAge() {
		return patAge;
	}

	public void setPatAge(String patAge) {
		this.patAge = patAge;
	}

	@XmlElement
	public String getPatIdType() {
		return patIdType;
	}

	public void setPatIdType(String patIdType) {
		this.patIdType = patIdType;
	}

	@XmlElement
	public String getPatIdNo() {
		return patIdNo;
	}

	public void setPatIdNo(String patIdNo) {
		this.patIdNo = patIdNo;
	}

	@XmlElement
	public String getPatCardType() {
		return patCardType;
	}

	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	@XmlElement
	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	@XmlElement
	public String getPatMobile() {
		return patMobile;
	}

	public void setPatMobile(String patMobile) {
		this.patMobile = patMobile;
	}

	@XmlElement
	public String getPatAddress() {
		return patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	@XmlElement
	public String getGuardName() {
		return guardName;
	}

	public void setGuardName(String guardName) {
		this.guardName = guardName;
	}

	@XmlElement
	public String getGuardIdType() {
		return guardIdType;
	}

	public void setGuardIdType(String guardIdType) {
		this.guardIdType = guardIdType;
	}

	@XmlElement
	public String getGuardIdNo() {
		return guardIdNo;
	}

	public void setGuardIdNo(String guardIdNo) {
		this.guardIdNo = guardIdNo;
	}
}
