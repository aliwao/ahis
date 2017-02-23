package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class PhyExamItemDetailSereachResponse extends BaseResponse {

	// 科室小结
	private String deptSummary;
	// 检验报告详情
	private List<PhyExamInspectReportItem> inspectItemList;
	// 检查报告详情
	private List<PhyExamCheckReportItem> checkItemList;

	@XmlElement
	public String getDeptSummary() {
		return deptSummary;
	}

	public void setDeptSummary(String deptSummary) {
		this.deptSummary = deptSummary;
	}

	@XmlElement(name = "inspectItem")
	public List<PhyExamInspectReportItem> getInspectItemList() {
		return inspectItemList;
	}

	public void setInspectItemList(List<PhyExamInspectReportItem> inspectItemList) {
		this.inspectItemList = inspectItemList;
	}

	@XmlElement(name = "checkItem")
	public List<PhyExamCheckReportItem> getCheckItemList() {
		return checkItemList;
	}

	public void setCheckItemList(List<PhyExamCheckReportItem> checkItemList) {
		this.checkItemList = checkItemList;
	}

}
