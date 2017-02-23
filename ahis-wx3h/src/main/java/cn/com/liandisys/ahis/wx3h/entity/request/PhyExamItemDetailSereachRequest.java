package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class PhyExamItemDetailSereachRequest extends BaseRequest {

	// 体检人姓名
	private String patName;
	// 体检号
	private String patCardNo;
	// 检验报告ID
	private String phyExamId;
	// 项目ID
	private String itemId;

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

	@XmlElement
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

}
