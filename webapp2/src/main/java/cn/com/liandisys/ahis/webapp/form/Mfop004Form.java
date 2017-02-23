package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.PayDetailEntity;

/**
 * 缴费明细Form。
 * 
 */
public class Mfop004Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1494531434742486719L;

	private List<PayDetailEntity> detailList;

	public List<PayDetailEntity> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<PayDetailEntity> detailList) {
		this.detailList = detailList;
	}

}
