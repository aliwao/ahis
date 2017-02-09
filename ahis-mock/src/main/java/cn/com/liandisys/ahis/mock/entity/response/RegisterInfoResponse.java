package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

/**
 * 预约号源信息Response。
 * 
 * @author xuyue
 * @version 1.0
 */
@XmlRootElement(name = "Response")
public class RegisterInfoResponse extends BaseResponse {

	private List<RegisterInfoItem> itemList;

	@XmlElement(name = "item")
	public List<RegisterInfoItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<RegisterInfoItem> itemList) {
		this.itemList = itemList;
	}
}
