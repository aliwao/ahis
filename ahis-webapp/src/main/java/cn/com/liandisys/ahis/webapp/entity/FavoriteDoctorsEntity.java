package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 收藏医生Entity。
 * 
 * @author xuyue
 * @version 1.0
 */
public class FavoriteDoctorsEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7389117732481381846L;

	/** 用户ID */
	private Long userId;

	/** 科室代码 */
	private String deptCode;

	/** 科室名称 */
	private String deptName;

	/** 收藏的医生代码 */
	private String doctorCode;

	/** 收藏的医生名称 */
	private String doctorName;

	/** 创建时间 */
	private Timestamp insertTimeStamp;


	public Long getUserId() {
		return userId;
    }

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Timestamp getInsertTimeStamp() {
		return insertTimeStamp;
	}

	public void setInsertTimeStamp(Timestamp insertTimeStamp) {
		this.insertTimeStamp = insertTimeStamp;
	}

}