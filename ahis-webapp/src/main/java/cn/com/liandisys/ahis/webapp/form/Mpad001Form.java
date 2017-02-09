package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.SiteInfoEntity;

public class Mpad001Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6163606064923668039L;

	private List<SiteInfoEntity> sitelist;

	public List<SiteInfoEntity> getSitelist() {
		return sitelist;
	}

	public void setSitelist(List<SiteInfoEntity> sitelist) {
		this.sitelist = sitelist;
	}
}
