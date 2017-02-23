package cn.com.liandisys.ahis.webapp.his.entity.request.base;


public class HospitalizationBaseHisRequest extends AbstractHisRequest {

	/** serialVersionUID */
	private static final long serialVersionUID = -4223056628676061169L;

	/** 诊疗卡类型 */
	private String patCardType;
	/** 诊疗卡号 */
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
