package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.PatientsHospitalizedEntity;

/**
 * 入院履历页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfih002Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1150881986430957329L;

	/** 检索条件 */
	private String searchKey;

	/** 入院履历信息 */
	private List<PatientsHospitalizedEntity> hospitalizedList;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public List<PatientsHospitalizedEntity> getHospitalizedList() {
		return hospitalizedList;
	}

	public void setHospitalizedList(List<PatientsHospitalizedEntity> hospitalizedList) {
		this.hospitalizedList = hospitalizedList;
	}

}
