package cn.com.liandisys.ahis.webapp.entity;

public class NumberSourceEntity {
	/** 号源日期 */
	private String scheduleDate;
	/** 时段 1：上午 2：下午 3：晚上 */
	private String timeFlag;
	/** 剩余可预约号源数 */
	private String leftNum;
	/** 挂号费 */
	private String regFee;
	private String week;

	public String getScheduleDate() {
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

	public String getLeftNum() {
		return leftNum;
	}

	public void setLeftNum(String leftNum) {
		this.leftNum = leftNum;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getRegFee() {
		return regFee;
	}

	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

}
