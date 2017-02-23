package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.HospitalizationBaseItem;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 住院记录查询 Response。
 * 
 * @author xuyue
 *
 */
public class HospitalizationBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = -6212648623593400877L;

	@JSONField(name="item")
	private List<HospitalizationBaseItem> itemList;

	public List<HospitalizationBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<HospitalizationBaseItem> itemList) {
		this.itemList = itemList;
	}
}
