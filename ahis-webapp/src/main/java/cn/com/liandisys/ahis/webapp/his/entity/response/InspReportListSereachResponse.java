package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Response")
public class InspReportListSereachResponse extends BaseResponse {

	private List<InspReportListSereachItem> itemList;

	@XmlElement(name = "item")
	public List<InspReportListSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<InspReportListSereachItem> itemList) {
		this.itemList = itemList;
	}
}
