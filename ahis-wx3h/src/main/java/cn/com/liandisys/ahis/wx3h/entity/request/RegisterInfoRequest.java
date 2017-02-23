package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 预约号源信息Request。
 * 
 * @author xuyue
 * @version 1.0
 */
@XmlRootElement(name = "Request")
public class RegisterInfoRequest extends BaseRequest {

	/** 号源开始日期 YYYY-MM-DD */
	private String beginDate;
	/** 号源结束日期 YYYY-MM-DD */
	private String endDate;
	/** 科室代码 */
	private String deptCode;
	/** 医生代码 */
	private String doctorCode;

	@XmlElement
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	@XmlElement
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@XmlElement
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	@XmlElement
	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
}
