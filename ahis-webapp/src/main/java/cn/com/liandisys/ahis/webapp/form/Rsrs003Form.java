package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.his.entity.response.PhyExamCheckReportItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.PhyExamInspectReportItem;

/**
 * 体检项目详情Form。
 * 
 */
public class Rsrs003Form extends AbstractAhisForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2786680359142093853L;

	// 科室小结
	private String deptSummary;
	// 检验报告详情list
	private List<PhyExamInspectReportItem> inspectList;
	// 检查报告详情list
	private List<PhyExamCheckReportItem> checkList;

	public String getDeptSummary() {
		return deptSummary;
	}

	public void setDeptSummary(String deptSummary) {
		this.deptSummary = deptSummary;
	}

	public List<PhyExamInspectReportItem> getInspectList() {
		return inspectList;
	}

	public void setInspectList(List<PhyExamInspectReportItem> inspectList) {
		this.inspectList = inspectList;
	}

	public List<PhyExamCheckReportItem> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<PhyExamCheckReportItem> checkList) {
		this.checkList = checkList;
	}

}
