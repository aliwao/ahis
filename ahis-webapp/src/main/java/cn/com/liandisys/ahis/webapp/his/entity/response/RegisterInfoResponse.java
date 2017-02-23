package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 预约号源信息Response。
 * 
 * @author xuyue
 * @version 1.0
 */
public class RegisterInfoResponse extends BaseResponse {

	@JSONField(name="item")
	private List<RegisterInfoItem> itemList;

	public List<RegisterInfoItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegisterInfoItem> itemList) {
		this.itemList = itemList;
	}
}
