package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;

/**
 * 缴费一览Form。
 * 
 */
public class Mfop001Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1494531434742486719L;

	/** 医保卡余额 */
	private String balance;
	/** 医院订单list */
	private List<HospitalOrderEntity> orderList;
	/** 已支付list */
	private List<HospitalOrderEntity> hasPaidList;
	/** 医院订单号 */
	private String hidHisOrdNum;
	/** 诊疗卡类型 */
	private String hidPatCardType;
	/** 诊疗卡号 */
	private String hidPatCardNo;
	/** 已支付一览初期表示flg */
	private String isPaid;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public List<HospitalOrderEntity> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<HospitalOrderEntity> orderList) {
		this.orderList = orderList;
	}

	public List<HospitalOrderEntity> getHasPaidList() {
		return hasPaidList;
	}

	public void setHasPaidList(List<HospitalOrderEntity> hasPaidList) {
		this.hasPaidList = hasPaidList;
	}

	public String getHidHisOrdNum() {
		return hidHisOrdNum;
	}

	public void setHidHisOrdNum(String hidHisOrdNum) {
		this.hidHisOrdNum = hidHisOrdNum;
	}

	public String getHidPatCardType() {
		return hidPatCardType;
	}

	public void setHidPatCardType(String hidPatCardType) {
		this.hidPatCardType = hidPatCardType;
	}

	public String getHidPatCardNo() {
		return hidPatCardNo;
	}

	public void setHidPatCardNo(String hidPatCardNo) {
		this.hidPatCardNo = hidPatCardNo;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

}
