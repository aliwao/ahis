package cn.com.liandisys.ahis.webapp.his.entity.request.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class PaymentRecordBaseHisRequest extends AbstractHisRequest{

	/** serialVersionUID */
	private static final long serialVersionUID = 3963945573769360655L;
	private String patCardType;
	private String patCardNo;

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
}
