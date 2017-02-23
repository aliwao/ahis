package cn.com.liandisys.ahis.webapp.his.entity.response.base.item;

public class PhyExamReportListBaseItem {

	// 体检报告ID
	private String phyExamId;
	// 体检名称
	private String phyExamName;
	// 体检时间
	private String phyExamTime;

	public String getPhyExamId() {
		return phyExamId;
	}

	public void setPhyExamId(String phyExamId) {
		this.phyExamId = phyExamId;
	}

	public String getPhyExamName() {
		return phyExamName;
	}

	public void setPhyExamName(String phyExamName) {
		this.phyExamName = phyExamName;
	}

	public String getPhyExamTime() {
		return phyExamTime;
	}

	public void setPhyExamTime(String phyExamTime) {
		this.phyExamTime = phyExamTime;
	}

}
