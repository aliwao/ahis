package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class PayRecordSereachResponse extends BaseResponse{

	
	private List<PayRecordSereachItem> itemList;

	@XmlElement(name = "item")
	public List<PayRecordSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PayRecordSereachItem> itemList) {
		this.itemList = itemList;
	}
}
