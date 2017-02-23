package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PaymentDetailBaseItem;

public class PaymentDetailBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = -5409414064188057739L;
	
	@JSONField(name="item")
	private List<PaymentDetailBaseItem> itemList;

	public List<PaymentDetailBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<PaymentDetailBaseItem> itemList) {
		this.itemList = itemList;
	}
}
