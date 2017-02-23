package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.RegisterBaseItem;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 预约号源信息Response。
 * 
 * @author xuyue
 * @version 1.0
 */
public class RegisterBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = -3706230290866485317L;

	@JSONField(name="item")
	private List<RegisterBaseItem> itemList;

	public List<RegisterBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegisterBaseItem> itemList) {
		this.itemList = itemList;
	}
}
