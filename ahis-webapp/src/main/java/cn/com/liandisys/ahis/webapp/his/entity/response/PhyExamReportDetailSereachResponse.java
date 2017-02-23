package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class PhyExamReportDetailSereachResponse extends BaseResponse {

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
	// 体检人姓名
	private List<PhyExamReportDetailSereachItem> itemList;

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
	public String getPhyExamNo() {
		return phyExamNo;
	}

	public void setPhyExamNo(String phyExamNo) {
		this.phyExamNo = phyExamNo;
	}

	@XmlElement
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@XmlElement
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@XmlElement
	public String getPhyExamTime() {
		return phyExamTime;
	}

	public void setPhyExamTime(String phyExamTime) {
		this.phyExamTime = phyExamTime;
	}

	@XmlElement
	public String getPhyExamReview() {
		return phyExamReview;
	}

	public void setPhyExamReview(String phyExamReview) {
		this.phyExamReview = phyExamReview;
	}

	@XmlElement
	public String getDoctorAdvice() {
		return doctorAdvice;
	}

	public void setDoctorAdvice(String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}

	@XmlElement(name = "item")
	public List<PhyExamReportDetailSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PhyExamReportDetailSereachItem> itemList) {
		this.itemList = itemList;
	}

}
