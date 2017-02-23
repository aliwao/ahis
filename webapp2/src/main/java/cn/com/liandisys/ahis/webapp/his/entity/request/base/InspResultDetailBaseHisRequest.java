package cn.com.liandisys.ahis.webapp.his.entity.request.base;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Request")
public class InspResultDetailBaseHisRequest extends AbstractHisRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3069922119118805683L;
	private String patCardType;
	private String patCardNo;
	private String checkId;

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
	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

}
