package cn.com.liandisys.ahis.webapp.his.entity.response;

public class AppointmentResponse extends BaseResponse {
	/**
	 * 医院订单号
	 */
	private String hisOrdNum;
	/**
	 * 就诊序号
	 */
	private String serialNum;
	/**
	 * 就诊位置
	 */
	private String visitPosition;
	/**
	 * 就诊说明
	 */
	private String visitDesc;

	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getVisitPosition() {
		return visitPosition;
	}

	public void setVisitPosition(String visitPosition) {
		this.visitPosition = visitPosition;
	}

	public String getVisitDesc() {
		return visitDesc;
	}

	public void setVisitDesc(String visitDesc) {
		this.visitDesc = visitDesc;
	}
}
