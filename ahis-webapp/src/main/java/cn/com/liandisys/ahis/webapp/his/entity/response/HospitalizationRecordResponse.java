package cn.com.liandisys.ahis.webapp.his.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 住院记录查询 Response。
 * 
 * @author xuyue
 *
 */
public class HospitalizationRecordResponse extends BaseResponse {

	@JSONField(name="item")
	private List<HospitalizationRecordItem> itemList;

	public List<HospitalizationRecordItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<HospitalizationRecordItem> itemList) {
		this.itemList = itemList;
	}
}
