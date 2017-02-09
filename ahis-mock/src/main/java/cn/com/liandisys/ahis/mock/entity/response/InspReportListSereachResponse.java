package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

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
