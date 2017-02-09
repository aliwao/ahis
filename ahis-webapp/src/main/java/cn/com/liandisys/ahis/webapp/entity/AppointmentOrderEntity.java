package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class AppointmentOrderEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8701559171721975697L;

	private long userId;
	private String psOrdNum;
	private String hisOrdNum;
	private String patCardType;
	private String patCardNo;
	private int status;
	private Timestamp insertTimeStamp;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getPsOrdNum() {
		return psOrdNum;
	}

	public void setPsOrdNum(String psOrdNum) {
		this.psOrdNum = psOrdNum;
	}

	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	public String getPatCardType() {
		return patCardType;
	}

	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}
}
