package cn.com.liandisys.ahis.mock.entity.response;

public class RegRecordSereachItem {

	private int hisOrdNum;
	private String regChannel;
	private String regChannelDesc;
	private String payChannel;
	private String payChannelDesc;
	private String isPaid;
	private String status;
	private String deptCode;
	private String deptName;
	private String doctorCode;
	private String doctorName;
	private String scheduleDate;
	private String timeFlag;
	private String beginTime;
	private String endTime;
	private double regFee;

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
	 * 预约渠道代码
	 */
	public String getRegChannel() {
		return regChannel;
	}

	public void setRegChannel(String regChannel) {
		this.regChannel = regChannel;
	}

	/**
	 * 预约渠道说明
	 */
	public String getRegChannelDesc() {
		return regChannelDesc;
	}

	public void setRegChannelDesc(String regChannelDesc) {
		this.regChannelDesc = regChannelDesc;
	}

	/**
	 * 付费渠道代码
	 */
	public String getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(String payChannel) {
		this.payChannel = payChannel;
	}

	/**
	 * 付费渠道说明
	 */
	public String getPayChannelDesc() {
		return payChannelDesc;
	}

	public void setPayChannelDesc(String payChannelDesc) {
		this.payChannelDesc = payChannelDesc;
	}

	/**
	 * 是否已付费
	 */
	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	/**
	 * 当前状态
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 科室代码
	 */
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 科室名称
	 */
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 医生代码
	 */
	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	/**
	 * 医生姓名
	 */
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	/**
	 * 分时开始时间
	 */
	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * 分时结束时间
	 */
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public double getRegFee() {
		return regFee;
	}

	/**
	 * 挂号费
	 */
	public void setRegFee(double regFee) {
		this.regFee = regFee;
	}
}
