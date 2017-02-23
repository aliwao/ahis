package cn.com.liandisys.ahis.webapp.his.entity.request.base;


public class HospitalizationFeeBaseHisRequest extends AbstractHisRequest {

	/** serialVersionUID */
	private static final long serialVersionUID = 3274972909716865056L;

	/** 诊疗卡类型 */
	private String patCardType;
	/** 诊疗卡号 */
	private String patCardNo;
	/** 住院号 */
	private String admissionNum;
	/** 清单开始日期 */
	private String beginDate;
	/** 清单结束日期 */
	private String endDate;

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

	public String getAdmissionNum() {
		return admissionNum;
	}

	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
