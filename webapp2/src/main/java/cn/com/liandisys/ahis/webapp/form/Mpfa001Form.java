package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.FavoriteDoctorsEntity;

public class Mpfa001Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6163606064923668039L;

	private List<FavoriteDoctorsEntity> favDocslist;

	public List<FavoriteDoctorsEntity> getFavDocslist() {
		return favDocslist;
	}

	public void setFavDocslist(List<FavoriteDoctorsEntity> favDocslist) {
		this.favDocslist = favDocslist;
	}

}
