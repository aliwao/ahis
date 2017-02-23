package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamReportListBaseItem;

public class PhyExamReportListBaseHisResponse extends AbstractHisResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8722701354282200309L;
	
	@JSONField(name="item")
	private List<PhyExamReportListBaseItem> itemList;

	public List<PhyExamReportListBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PhyExamReportListBaseItem> itemList) {
		this.itemList = itemList;
	}
}
