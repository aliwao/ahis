package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.BankCardInfoEntity;

/**
 * 我的银行卡页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mpst006Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5399909664074750222L;

	List<BankCardInfoEntity> bankCardList;

	public List<BankCardInfoEntity> getBankCardList() {
		return bankCardList;
	}

	public void setBankCardList(List<BankCardInfoEntity> bankCardList) {
		this.bankCardList = bankCardList;
	}

}
