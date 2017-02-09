package cn.com.liandisys.ahis.mock.entity.response;

import javax.xml.bind.annotation.XmlElement;

/**
 * 预约号源信息Item。
 * 
 * @author xuyue
 * @version 1.0
 */
public class RegisterInfoItem {
	/** 科室代码 */
	private String deptCode;
	/** 医生代码 */
	private String doctorCode;
	/** 号源日期 */
	@XmlElement(name = "scheduleDate")
	private String scheduleDate;
	/** 时段 1：上午 2：下午 3：晚上 */
	private String timeFlag;
	/** 是否有分时 */
	private String hasDetailTime;
	/** 开始时间 */
	private String beginTime;
	/** 结束时间 */
	private String endTime;
	/** 出诊状态 */
	private String workStatus;
	/** 挂号费 */
	private String regFee;
	/** 号源总数 */
	private String totalNum;
	/** 剩余可预约号源数 */
	private String leftNum;

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

	public String getHasChild() {
		return scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getTimeFlag() {
		return timeFlag;
	}

	public void setTimeFlag(String timeFlag) {
		this.timeFlag = timeFlag;
	}

	public String getHasDetailTime() {
		return hasDetailTime;
	}

	public void setHasDetailTime(String hasDetailTime) {
		this.hasDetailTime = hasDetailTime;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}

	public String getRegFee() {
		return regFee;
	}

	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

	public String getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(String totalNum) {
		this.totalNum = totalNum;
	}

	public String getLeftNum() {
		return leftNum;
	}

	public void setLeftNum(String leftNum) {
		this.leftNum = leftNum;
	}

}
