package cn.com.liandisys.ahis.webapp.his.entity.response;

public class HospitalDeptItem {

	private String deptCode;
	private String deptName;
	private String hasChild;
	private String parentDeptCode;
	private String deptDescription;
	private String deptLocation;
	/* 是否可挂号 0：不可 1：可 */
	private String canRegister;

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

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	public String getParentDeptCode() {
		return parentDeptCode;
	}

	public void setParentDeptCode(String parentDeptCode) {
		this.parentDeptCode = parentDeptCode;
	}

	public String getDeptDescription() {
		return deptDescription;
	}

	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}

	public String getDeptLocation() {
		return deptLocation;
	}

	public void setDeptLocation(String deptLocation) {
		this.deptLocation = deptLocation;
	}

	public String getCanRegister() {
		return canRegister;
	}

	public void setCanRegister(String canRegister) {
		this.canRegister = canRegister;
	}

}
