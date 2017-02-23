package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.RegisterRecordBaseItem;

public class RegisterRecordBaseHisResponse extends AbstractHisResponse{

	/** serialVersionUID */
	private static final long serialVersionUID = 1801497796932763063L;
	
	@JSONField(name="item")
	private List<RegisterRecordBaseItem> itemList;

	public List<RegisterRecordBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegisterRecordBaseItem> itemList) {
		this.itemList = itemList;
	}
}
