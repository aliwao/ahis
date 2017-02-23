package cn.com.liandisys.ahis.webapp.his.entity.request.base;

public class DeptBaseHisRequest extends AbstractHisRequest {

	/** serialVersionUID */
	private static final long serialVersionUID = 7788061112839006110L;

	/** 科室CODE */
	private String deptCode;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
}
