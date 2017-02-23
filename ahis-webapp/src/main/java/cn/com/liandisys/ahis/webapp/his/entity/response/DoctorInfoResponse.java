package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 医生信息Response。
 * 
 * @author xuyue
 * @version 1.0
 */
public class DoctorInfoResponse extends BaseResponse {

	@JSONField(name="item")
	private List<DoctorInfoItem> itemList;

	public List<DoctorInfoItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DoctorInfoItem> itemList) {
		this.itemList = itemList;
	}
}
