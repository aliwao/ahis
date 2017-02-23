package cn.com.liandisys.ahis.webapp.entity;

import java.io.Serializable;
import java.util.List;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamReportDetailBaseItem;

public class PhyExamReportDetailEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5385299734526584186L;

	// 体检人姓名
	private String patName;
	// 体检人性别
	private String patSex;
	// 体检编号
	private String phyExamNo;
	// 体检科室名称
	private String deptName;
	// 体检医生名称
	private String doctorName;
	// 体检时间
	private String phyExamTime;
	// 体检综述
	private String phyExamReview;
	// 医生意见
	private String doctorAdvice;
	// 报告详情
	private List<PhyExamReportDetailBaseItem> itemList;

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

	public String getPhyExamNo() {
		return phyExamNo;
	}

	public void setPhyExamNo(String phyExamNo) {
		this.phyExamNo = phyExamNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPhyExamTime() {
		return phyExamTime;
	}

	public void setPhyExamTime(String phyExamTime) {
		this.phyExamTime = phyExamTime;
	}

	public String getPhyExamReview() {
		return phyExamReview;
	}

	public void setPhyExamReview(String phyExamReview) {
		this.phyExamReview = phyExamReview;
	}

	public String getDoctorAdvice() {
		return doctorAdvice;
	}

	public void setDoctorAdvice(String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}

	public List<PhyExamReportDetailBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PhyExamReportDetailBaseItem> itemList) {
		this.itemList = itemList;
	}

}
