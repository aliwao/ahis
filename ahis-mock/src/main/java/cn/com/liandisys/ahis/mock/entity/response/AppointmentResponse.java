package cn.com.liandisys.ahis.mock.entity.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;

@XmlRootElement(name = "Response")
public class AppointmentResponse extends BaseResponse {
	/**
	 * 医院订单号
	 */
	private String hisOrdNum;
	/**
	 * 就诊序号
	 */
	private String serialNum;
	/**
	 * 就诊位置
	 */
	private String visitPosition;
	/**
	 * 就诊说明
	 */
	private String visitDesc;

	@XmlElement
	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	@XmlElement
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	@XmlElement
	public String getVisitPosition() {
		return visitPosition;
	}

	public void setVisitPosition(String visitPosition) {
		this.visitPosition = visitPosition;
	}

	@XmlElement
	public String getVisitDesc() {
		return visitDesc;
	}

	public void setVisitDesc(String visitDesc) {
		this.visitDesc = visitDesc;
	}
}
