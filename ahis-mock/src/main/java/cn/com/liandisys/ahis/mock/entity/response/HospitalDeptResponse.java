package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class HospitalDeptResponse extends BaseResponse {

	private List<HospitalDeptItem> itemList;

	@XmlElement(name = "item")
	public List<HospitalDeptItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<HospitalDeptItem> itemList) {
		this.itemList = itemList;
	}
}
