package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class CreatPatientInfoRequest extends BaseRequest {
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

	@XmlElement
	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	@XmlElement
	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	@XmlElement
	public String getPatAge() {
		return patAge;
	}

	public void setPatAge(String patAge) {
		this.patAge = patAge;
	}

	@XmlElement
	public String getPatBirth() {
		return patBirth;
	}

	public void setPatBirth(String patBirth) {
		this.patBirth = patBirth;
	}

	@XmlElement
	public String getPatAddress() {
		return patAddress;
	}

	public void setPatAddress(String patAddress) {
		this.patAddress = patAddress;
	}

	@XmlElement
	public String getPatMobile() {
		return patMobile;
	}

	public void setPatMobile(String patMobile) {
		this.patMobile = patMobile;
	}

	@XmlElement
	public String getPatIdType() {
		return patIdType;
	}

	public void setPatIdType(String patIdType) {
		this.patIdType = patIdType;
	}

	@XmlElement
	public String getPatIdNo() {
		return patIdNo;
	}

	public void setPatIdNo(String patIdNo) {
		this.patIdNo = patIdNo;
	}

	@XmlElement
	public String getGuardName() {
		return guardName;
	}

	public void setGuardName(String guardName) {
		this.guardName = guardName;
	}

	@XmlElement
	public String getGuardIdType() {
		return guardIdType;
	}

	public void setGuardIdType(String guardIdType) {
		this.guardIdType = guardIdType;
	}

	@XmlElement
	public String getGuardIdNo() {
		return guardIdNo;
	}

	public void setGuardIdNo(String guardIdNo) {
		this.guardIdNo = guardIdNo;
	}

	@XmlElement
	public String getPactCode() {
		return pactCode;
	}

	public void setPactCode(String pactCode) {
		this.pactCode = pactCode;
	}
}
