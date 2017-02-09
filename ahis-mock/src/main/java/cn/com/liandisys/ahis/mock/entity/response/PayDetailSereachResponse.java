package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class PayDetailSereachResponse extends BaseResponse {

	private List<PayDetailSereachItem> itemList;

	@XmlElement(name = "item")
	public List<PayDetailSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PayDetailSereachItem> itemList) {
		this.itemList = itemList;
	}
}
