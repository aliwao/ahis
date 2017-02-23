package cn.com.liandisys.ahis.webapp.dto;

public class DepartmentBasicEntity {

	private String hospitalCode;
	private String departmentCode;
	private String departmentName;
	private String hasChild;
	private String parentCode;
	private String departmentDescription;
	/* 是否可挂号 0：不可 1：可 */
	private String canRegister;

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

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getHasChild() {
		return hasChild;
	}

	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public String getCanRegister() {
		return canRegister;
	}

	public void setCanRegister(String canRegister) {
		this.canRegister = canRegister;
	}

}
