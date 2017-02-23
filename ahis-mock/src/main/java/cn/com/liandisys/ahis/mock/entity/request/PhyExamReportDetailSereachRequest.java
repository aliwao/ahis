package cn.com.liandisys.ahis.mock.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;

@XmlRootElement(name = "Request")
public class PhyExamReportDetailSereachRequest extends BaseRequest {

	// 体检人姓名
	private String patName;
	// 体检号
	private String patCardNo;
	// 检验报告ID
	private String phyExamId;

	@XmlElement
	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	@XmlElement
	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	@XmlElement
	public String getPhyExamId() {
		return phyExamId;
	}

	public void setPhyExamId(String phyExamId) {
		this.phyExamId = phyExamId;
	}

}
