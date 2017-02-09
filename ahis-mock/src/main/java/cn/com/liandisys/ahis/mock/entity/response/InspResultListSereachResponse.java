package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class InspResultListSereachResponse extends BaseResponse {

	private List<InspResultListSereachItem> itemList;

	@XmlElement(name = "item")
	public List<InspResultListSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<InspResultListSereachItem> itemList) {
		this.itemList = itemList;
	}
}
