package cn.com.liandisys.ahis.wx3h.entity.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class PayDetailSereachRequest extends BaseRequest {

	private String patCardType;
	private String patCardNo;
	private int hisOrdNum;

	@XmlElement
	public String getPatCardType() {
		return patCardType;
	}

	public void setPatCardType(String patCardType) {
		this.patCardType = patCardType;
	}

	@XmlElement
	public String getPatCardNo() {
		return patCardNo;
	}

	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}

	@XmlElement
	public int getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(int hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}
}
