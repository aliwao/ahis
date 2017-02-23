package cn.com.liandisys.ahis.webapp.common;

import java.io.Serializable;

public abstract class AbstractAhisForm implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3487893313622424854L;

	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
