package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.InspReportListBaseItem;

public class InspReportListBaseHisResponse extends AbstractHisResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2515800485333396431L;
	
	@JSONField(name="item")
	private List<InspReportListBaseItem> itemList;

	public List<InspReportListBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<InspReportListBaseItem> itemList) {
		this.itemList = itemList;
	}
}
