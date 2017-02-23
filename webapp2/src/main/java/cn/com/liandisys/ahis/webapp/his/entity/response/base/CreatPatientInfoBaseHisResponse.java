package cn.com.liandisys.ahis.webapp.his.entity.response.base;

public class CreatPatientInfoBaseHisResponse extends AbstractHisResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1329114293631081218L;
	/**
	 * 诊疗卡类型
	 */
	private String patCardType;
	/**
	 * 诊疗卡号码
	 */
	private String patCardNo;

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
}
