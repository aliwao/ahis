package cn.com.liandisys.ahis.webapp.form;

import java.util.List;
import java.util.Map;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptItem;

/**
 * 选择科室页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfrg001Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1494531434742486719L;

	/** 检索用科室名称 */
	private String deptName;

	/** 科室list */
	private Map<String, List<HospitalDeptItem>> deptItemMap;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Map<String, List<HospitalDeptItem>> getDeptItemMap() {
		return deptItemMap;
	}

	public void setDeptItemMap(Map<String, List<HospitalDeptItem>> deptItemMap) {
		this.deptItemMap = deptItemMap;
	}

}
