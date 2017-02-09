package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.RegDocInfoEntity;

/**
 * 预约挂号页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfrg002Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -406802926482447014L;

	/** 科室代码 */
	private String deptCode;

	/** 科室名称 */
	private String deptName;

	/** 当天日期 */
	private String todayDate;

	/** 预约门诊日期 */
	private String reserveDate;

	/** 最小可预约门诊日期 */
	private String minRserveDate;

	/** 最大可预约门诊日期 */
	private String maxRserveDate;

	/** 预约医生信息List */
	private List<RegDocInfoEntity> regDocList;

	/** 收藏的医生代码 */
	private String doctorCode;

	/** 收藏的医生名称 */
	private String doctorName;

	public String getTodayDate() {
		return todayDate;
	}

	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getMinReserveDate() {
		return minRserveDate;
	}

	public void setMinReserveDate(String minRserveDate) {
		this.minRserveDate = minRserveDate;
	}

	public String getMaxReserveDate() {
		return maxRserveDate;
	}

	public void setMaxReserveDate(String maxRserveDate) {
		this.maxRserveDate = maxRserveDate;
	}

	public List<RegDocInfoEntity> getRegDocList() {
		return regDocList;
	}

	public void setRegDocList(List<RegDocInfoEntity> regDocList) {
		this.regDocList = regDocList;
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

}
