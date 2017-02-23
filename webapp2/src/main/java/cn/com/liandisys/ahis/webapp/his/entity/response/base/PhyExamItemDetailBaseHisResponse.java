package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamCheckReportBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamInspectReportBaseItem;

public class PhyExamItemDetailBaseHisResponse extends AbstractHisResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805555567590105300L;
	// 科室小结
	private String deptSummary;
	// 检验报告详情
	@JSONField(name="inspectItem")
	private List<PhyExamInspectReportBaseItem> inspectItemList;
	// 检查报告详情
	@JSONField(name="checkItem")
	private List<PhyExamCheckReportBaseItem> checkItemList;

	public String getDeptSummary() {
		return deptSummary;
	}

	public void setDeptSummary(String deptSummary) {
		this.deptSummary = deptSummary;
	}

	public List<PhyExamInspectReportBaseItem> getInspectItemList() {
		return inspectItemList;
	}

	public void setInspectItemList(List<PhyExamInspectReportBaseItem> inspectItemList) {
		this.inspectItemList = inspectItemList;
	}

	public List<PhyExamCheckReportBaseItem> getCheckItemList() {
		return checkItemList;
	}

	public void setCheckItemList(List<PhyExamCheckReportBaseItem> checkItemList) {
		this.checkItemList = checkItemList;
	}

}
