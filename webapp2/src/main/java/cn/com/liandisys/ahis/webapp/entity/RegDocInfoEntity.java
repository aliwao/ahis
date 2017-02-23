package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

/**
 * 预约挂号页面显示的医生信息。
 * 
 * @author xuyue
 * @version 1.0
 */
public class RegDocInfoEntity implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8301241294614921215L;

	/** 科室代码 */
	private String deptCode;
	/** 医生代码 */
	private String doctorCode;
	/** 医生姓名 */
	private String doctorName;
	/** 医生职称 */
	private String doctorTitle;
	/** 医生简介 */
	private String doctorIntrodution;
	/** 医生擅长 */
	private String doctorSkill;
	/** 医生图片 */
	private String doctorPic;
	/** 上午 是否可预约 0:不可 1：可 */
	private String amCanReg;
	/** 下午 是否可预约 0:不可 1：可 */
	private String pmCanReg;
	/** 挂号费 （元） */
	private String regFee;

	/** 是否被当前用户收藏 */
	private String isCurUserFav;

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

	public String getDoctorTitle() {
		return doctorTitle;
	}

	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}

	public String getDoctorIntrodution() {
		return doctorIntrodution;
	}

	public void setDoctorIntrodution(String doctorIntrodution) {
		this.doctorIntrodution = doctorIntrodution;
	}

	public String getDoctorSkill() {
		return doctorSkill;
	}

	public void setDoctorSkill(String doctorSkill) {
		this.doctorSkill = doctorSkill;
	}

	public String getDoctorPic() {
		return doctorPic;
	}

	public void setDoctorPic(String doctorPic) {
		this.doctorPic = doctorPic;
	}

	public String getAmCanReg() {
		return amCanReg;
	}

	public void setAmCanReg(String amCanReg) {
		this.amCanReg = amCanReg;
	}

	public String getPmCanReg() {
		return pmCanReg;
	}

	public void setPmCanReg(String pmCanReg) {
		this.pmCanReg = pmCanReg;
	}

	public String getRegFee() {
		return regFee;
	}

	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}

	public String getIsCurUserFav() {
		return isCurUserFav;
	}

	public void setIsCurUserFav(String isCurUserFav) {
		this.isCurUserFav = isCurUserFav;
	}

}
