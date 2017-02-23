package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

/**
 * 住院清单 每日费用entity
 */
public class HospitalizationDayFeeEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7889304211178237490L;
	/** 日期 YYYY-dd-MM */
	private String date;
	/** 日期 */
	private String dateStr;
	/** 费用总金额 单位：分 */
	private String totalFee;
	/** 甲类金额 单位：分 */
	private String feeA;
	/** 乙类金额 单位：分 */
	private String feeB;
	/** 丙类金额 单位：分 */
	private String feeC;
	/** 床位费 单位：分 */
	private String bedFee;
	/** 西药费 单位：分 */
	private String westMedFee;
	/** 成药费 单位：分 */
	private String readyMedFee;
	/** 草药费 单位：分 */
	private String herbMedFee;
	/** 诊疗费 单位：分 */
	private String treatFee;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getFeeA() {
		return feeA;
	}

	public void setFeeA(String feeA) {
		this.feeA = feeA;
	}

	public String getFeeB() {
		return feeB;
	}

	public void setFeeB(String feeB) {
		this.feeB = feeB;
	}

	public String getFeeC() {
		return feeC;
	}

	public void setFeeC(String feeC) {
		this.feeC = feeC;
	}

	public String getBedFee() {
		return bedFee;
	}

	public void setBedFee(String bedFee) {
		this.bedFee = bedFee;
	}

	public String getWestMedFee() {
		return westMedFee;
	}

	public void setWestMedFee(String westMedFee) {
		this.westMedFee = westMedFee;
	}

	public String getReadyMedFee() {
		return readyMedFee;
	}

	public void setReadyMedFee(String readyMedFee) {
		this.readyMedFee = readyMedFee;
	}

	public String getHerbMedFee() {
		return herbMedFee;
	}

	public void setHerbMedFee(String herbMedFee) {
		this.herbMedFee = herbMedFee;
	}

	public String getTreatFee() {
		return treatFee;
	}

	public void setTreatFee(String treatFee) {
		this.treatFee = treatFee;
	}

}
