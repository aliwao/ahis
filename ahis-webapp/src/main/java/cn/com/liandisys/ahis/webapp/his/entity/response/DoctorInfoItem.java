package cn.com.liandisys.ahis.webapp.his.entity.response;

/**
 * 医生信息Item。
 * 
 * @author xuyue
 * @version 1.0
 */
public class DoctorInfoItem {
	/** 医院代码 */
	private String hospitalCode;
	/** 科室代码 */
	private String deptCode;
	/** 科室名称 */
	private String deptName;
	/** 医生代码 */
	private String doctorCode;
	/** 医生姓名 */
	private String doctorName;
	/** 医生擅长 */
	private String doctorSkill;
	/** 医生简介 */
	private String doctorIntrodution;
	/** 医生职称 */
	private String doctorTitle;

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorSkill() {
		return doctorSkill;
	}

	public void setDoctorSkill(String doctorSkill) {
		this.doctorSkill = doctorSkill;
	}

	public String getDoctorIntrodution() {
		return doctorIntrodution;
	}

	public void setDoctorIntrodution(String doctorIntrodution) {
		this.doctorIntrodution = doctorIntrodution;
	}

	public String getDoctorTitle() {
		return doctorTitle;
	}

	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}

}
