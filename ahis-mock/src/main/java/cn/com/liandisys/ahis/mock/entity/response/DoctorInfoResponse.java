package cn.com.liandisys.ahis.mock.entity.response;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

/**
 * 医生信息Response。
 * 
 * @author xuyue
 * @version 1.0
 */
@XmlRootElement(name = "Response")
public class DoctorInfoResponse extends BaseResponse {

	private List<DoctorInfoItem> itemList;

	@XmlElement(name = "item")
	public List<DoctorInfoItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<DoctorInfoItem> itemList) {
		this.itemList = itemList;
	}
}
