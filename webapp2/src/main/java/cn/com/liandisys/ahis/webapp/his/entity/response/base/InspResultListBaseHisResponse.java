package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.InspResultListBaseItem;

public class InspResultListBaseHisResponse extends AbstractHisResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7106442488458933360L;
	
	@JSONField(name="item")
	private List<InspResultListBaseItem> itemList;

	public List<InspResultListBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<InspResultListBaseItem> itemList) {
		this.itemList = itemList;
	}
}
