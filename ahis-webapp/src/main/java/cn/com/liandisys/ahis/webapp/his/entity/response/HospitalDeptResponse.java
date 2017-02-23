package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class HospitalDeptResponse extends BaseResponse {

	@JSONField(name="item")
	private List<HospitalDeptItem> itemList;

	public List<HospitalDeptItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<HospitalDeptItem> itemList) {
		this.itemList = itemList;
	}
}
