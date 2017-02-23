package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class RegRecordSereachResponse extends BaseResponse{

	@JSONField(name="item")
	private List<RegRecordSereachItem> itemList;

	public List<RegRecordSereachItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegRecordSereachItem> itemList) {
		this.itemList = itemList;
	}
}
