package cn.com.liandisys.ahis.webapp.his.entity.request.base;

public class ClinicPayNoticeBaseHisRequest extends AbstractHisRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9186508792713428525L;
	/** 诊疗卡类型 */
	private String patCardType;
	/** 诊疗卡号 */
	private String patCardNo;
	/** 医院订单号 */
	private String hisOrdNum;
	/** 平台订单号 */
	private String psOrdNum;
	/** 支付方式 */
	private String payMode;
	/** 补缴押金金额 单位：分 */
	private String payAmt;
	/** 收单机构流水号 */
	private String agtOrdNum;
	/** 支付时间 */
	private String payTime;

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

	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	public String getPsOrdNum() {
		return psOrdNum;
	}

	public void setPsOrdNum(String psOrdNum) {
		this.psOrdNum = psOrdNum;
	}

	public String getPayMode() {
		return payMode;
	}

	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}

	public String getPayAmt() {
		return payAmt;
	}

	public void setPayAmt(String payAmt) {
		this.payAmt = payAmt;
	}

	public String getAgtOrdNum() {
		return agtOrdNum;
	}

	public void setAgtOrdNum(String agtOrdNum) {
		this.agtOrdNum = agtOrdNum;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
}
