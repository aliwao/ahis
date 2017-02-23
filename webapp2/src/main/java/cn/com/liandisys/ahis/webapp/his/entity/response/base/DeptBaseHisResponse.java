package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.DeptBaseItem;

public class DeptBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = 127183192733025868L;

	@JSONField(name="item")
	private List<DeptBaseItem> itemList;

	public List<DeptBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DeptBaseItem> itemList) {
		this.itemList = itemList;
	}
}
