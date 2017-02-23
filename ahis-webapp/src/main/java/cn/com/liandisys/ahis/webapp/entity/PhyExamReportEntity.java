package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;

public class PhyExamReportEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1795677280633469980L;

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
