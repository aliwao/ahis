package cn.com.liandisys.ahis.webapp.his.entity.request.base;


/**
 * 医生信息Request。
 * 
 * @author xuyue
 * @version 1.0
 */
public class DoctorBaseHisRequest extends AbstractHisRequest {

	/** serialVersionUID */
	private static final long serialVersionUID = -7694055769964274062L;

	/** 科室代码 */
	private String deptCode;
	/** 医生代码 */
	private String doctorCode;

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
