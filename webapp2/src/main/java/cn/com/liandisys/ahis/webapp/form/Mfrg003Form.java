package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.NumberSourceEntity;

public class Mfrg003Form extends AbstractAhisForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 893279049090245718L;
	/**
	 * 医生头像路径
	 */
	private String imgPath;
	/** 科室代码 */
	private String deptCode;
	/** 科室名称 */
	private String deptName;
	/** 医生代码 */
	private String doctorCode;
	/** 医生姓名 */
	private String doctorName;
	/** 医生擅长 */
	private List<String> doctorSkill;
	/** 医生简介 */
	private String doctorIntrodution;
	/** 医生职称 */
	private String doctorTitle;

	private List<NumberSourceEntity> entityList;

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public List<String> getDoctorSkill() {
		return doctorSkill;
	}

	public void setDoctorSkill(List<String> doctorSkill) {
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

	public List<NumberSourceEntity> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<NumberSourceEntity> entityList) {
		this.entityList = entityList;
	}

}
