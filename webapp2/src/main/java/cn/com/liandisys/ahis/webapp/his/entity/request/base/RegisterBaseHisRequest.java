package cn.com.liandisys.ahis.webapp.his.entity.request.base;


/**
 * 预约号源信息Request。
 * 
 * @author xuyue
 * @version 1.0
 */
public class RegisterBaseHisRequest extends AbstractHisRequest {

	/** serialVersionUID */
	private static final long serialVersionUID = -6730833036496104238L;

	/** 号源开始日期 YYYY-MM-DD */
	private String beginDate;
	/** 号源结束日期 YYYY-MM-DD */
	private String endDate;
	/** 科室代码 */
	private String deptCode;
	/** 医生代码 */
	private String doctorCode;

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

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
}
