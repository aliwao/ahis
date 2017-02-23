package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.HospitalizationDayFeeEntity;

/**
 * 住院清单页面Form。
 * 
 * @author xuyue
 * @version 1.0
 */
public class Mfis009Form extends AbstractAhisForm {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2094117524060092809L;

	/** 住院人 */
	private String userName;
	/** 已收押金 */
	private String recievedDeposit;
	/** 未缴费 */
	private String notPayed;
	/** 总费用 */
	private String totalFee;
	/** 每日费用清单 */
	List<HospitalizationDayFeeEntity> dayFeeList;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRecievedDeposit() {
		return recievedDeposit;
	}

	public void setRecievedDeposit(String recievedDeposit) {
		this.recievedDeposit = recievedDeposit;
	}

	public String getNotPayed() {
		return notPayed;
	}

	public void setNotPayed(String notPayed) {
		this.notPayed = notPayed;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public List<HospitalizationDayFeeEntity> getDayFeeList() {
		return dayFeeList;
	}

	public void setDayFeeList(List<HospitalizationDayFeeEntity> dayFeeList) {
		this.dayFeeList = dayFeeList;
	}

}
