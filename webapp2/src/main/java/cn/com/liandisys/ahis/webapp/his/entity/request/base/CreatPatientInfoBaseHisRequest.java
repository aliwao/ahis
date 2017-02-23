package cn.com.liandisys.ahis.webapp.his.entity.request.base;

public class CreatPatientInfoBaseHisRequest extends AbstractHisRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5963053423162790875L;
	/**
	 * 姓名
	 */
	private String patName;
	/**
	 * 性别
	 */
	private String patSex;
	/**
	 * 年龄
	 */
	private String patAge;
	/**
	 * 出生日期
	 */
	private String patBirth;
	/**
	 * 地址
	 */
	private String patAddress;
	/**
	 * 电话
	 */
	private String patMobile;
	/**
	 * 证件类型
	 */
	private String patIdType;
	/**
	 * 证件号码
	 */
	private String patIdNo;
	/**
	 * 监护人姓名
	 */
	private String guardName;
	/**
	 * 监护人证件类型
	 */
	private String guardIdType;
	/**
	 * 监护人证件号码
	 */
	private String guardIdNo;
	/**
	 * 
	 */
	private String pactCode;

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public String getPatAge() {
		return patAge;
	}

	public void setPatAge(String patAge) {
		this.patAge = patAge;
	}

	public String getPatBirth() {
		return patBirth;
	}

	public void setPatBirth(String patBirth) {
		this.patBirth = patBirth;
	}

	public String getPatAddress() {
		return patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	public String getPatMobile() {
		return patMobile;
	}

	public void setPatMobile(String patMobile) {
		this.patMobile = patMobile;
	}

	public String getPatIdType() {
		return patIdType;
	}

	public void setPatIdType(String patIdType) {
		this.patIdType = patIdType;
	}

	public String getPatIdNo() {
		return patIdNo;
	}

	public void setPatIdNo(String patIdNo) {
		this.patIdNo = patIdNo;
	}

	public String getGuardName() {
		return guardName;
	}

	public void setGuardName(String guardName) {
		this.guardName = guardName;
	}

	public String getGuardIdType() {
		return guardIdType;
	}

	public void setGuardIdType(String guardIdType) {
		this.guardIdType = guardIdType;
	}

	public String getGuardIdNo() {
		return guardIdNo;
	}

	public void setGuardIdNo(String guardIdNo) {
		this.guardIdNo = guardIdNo;
	}

	public String getPactCode() {
		return pactCode;
	}

	public void setPactCode(String pactCode) {
		this.pactCode = pactCode;
	}
}
