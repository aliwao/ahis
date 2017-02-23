package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamCheckReportBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamInspectReportBaseItem;

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
	private List<PhyExamInspectReportBaseItem> inspectList;
	// 检查报告详情list
	private List<PhyExamCheckReportBaseItem> checkList;

	public String getDeptSummary() {
		return deptSummary;
	}

	public void setDeptSummary(String deptSummary) {
		this.deptSummary = deptSummary;
	}

	public List<PhyExamInspectReportBaseItem> getInspectList() {
		return inspectList;
	}

	public void setInspectList(List<PhyExamInspectReportBaseItem> inspectList) {
		this.inspectList = inspectList;
	}

	public List<PhyExamCheckReportBaseItem> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<PhyExamCheckReportBaseItem> checkList) {
		this.checkList = checkList;
	}

}
