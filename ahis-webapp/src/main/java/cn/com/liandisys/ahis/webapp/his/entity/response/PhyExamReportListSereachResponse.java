package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class PhyExamReportListSereachResponse extends BaseResponse {

	private List<PhyExamReportListSereachItem> itemList;

	@XmlElement(name = "item")
	public List<PhyExamReportListSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PhyExamReportListSereachItem> itemList) {
		this.itemList = itemList;
	}
}
