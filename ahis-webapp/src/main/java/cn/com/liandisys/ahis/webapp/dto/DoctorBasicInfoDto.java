package cn.com.liandisys.ahis.webapp.dto;

/**
 * 医生DB信息Item。
 * 
 * @author xuyue
 * @version 1.0
 */
public class DoctorBasicInfoDto {
	/** 医院代码 */
	private String hospitalCode;
	/** 科室代码 */
	private String departmentCode;
	/** 科室名称 */
	private String departmentName;
	/** 医生代码 */
	private String doctorCode;
	/** 医生姓名 */
	private String doctorName;
	/** 医生擅长 */
	private String skill;
	/** 医生简介 */
	private String summary;
	/** 医生职称 */
	private String rank;
	/** 医生头像 */
	private String portrait;

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

}
