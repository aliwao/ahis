package cn.com.liandisys.ahis.webapp.his.entity.request.base;

public class AppointmentCancelBaseHisRequest extends AbstractHisRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6805557816975699053L;

	/**
	 * 医院订单号
	 */
	private String hisOrdNum;

	/**
	 * 平台订单号
	 */
	private String psOrdNum;
	/**
	 * 取消原因
	 */
	private String cancelReason;

	private String serialNum;

	private String registerType;

	
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

	
	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	
	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
}
