package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class RegRecordSereachResponse extends BaseResponse{

	private List<RegRecordSereachItem> itemList;

	@XmlElement(name = "item")
	public List<RegRecordSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegRecordSereachItem> itemList) {
		this.itemList = itemList;
	}
}
