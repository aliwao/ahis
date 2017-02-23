package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.io.Serializable;

public class AbstractHisResponse implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -6266302503169542401L;

	private String resultCode;
	private String resultMessage;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
