package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PaymentRecordBaseItem;

public class PaymentRecordBaseHisResponse extends AbstractHisResponse{

	
	/** serialVersionUID */
	private static final long serialVersionUID = 5739585547165251562L;
	
	@JSONField(name="item")
	private List<PaymentRecordBaseItem> itemList;

	public List<PaymentRecordBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PaymentRecordBaseItem> itemList) {
		this.itemList = itemList;
	}
}
