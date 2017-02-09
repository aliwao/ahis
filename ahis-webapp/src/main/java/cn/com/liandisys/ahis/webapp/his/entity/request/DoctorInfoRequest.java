package cn.com.liandisys.ahis.webapp.his.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 医生信息Request。
 * 
 * @author xuyue
 * @version 1.0
 */
@XmlRootElement(name = "Request")
public class DoctorInfoRequest extends BaseRequest {

	/** 科室代码 */
	private String deptCode;
	/** 医生代码 */
	private String doctorCode;

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
