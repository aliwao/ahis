package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.DoctorBaseItem;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 医生信息Response。
 * 
 * @author xuyue
 * @version 1.0
 */
public class DoctorBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = -4408545421804231233L;

	@JSONField(name="item")
	private List<DoctorBaseItem> itemList;

	public List<DoctorBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DoctorBaseItem> itemList) {
		this.itemList = itemList;
	}
}
