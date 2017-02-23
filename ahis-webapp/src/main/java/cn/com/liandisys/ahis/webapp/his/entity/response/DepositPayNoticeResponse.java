package cn.com.liandisys.ahis.webapp.his.entity.response;

/**
 * 住院押金补缴支付 Response。
 * 
 * @author xuyue
 *
 */
public class DepositPayNoticeResponse extends BaseResponse {

	/** 医院交易流水号 */
	private String hisOrdNum;
	/** 押金当前余 */
	private String balance;

	public String getHisOrdNum() {
		return hisOrdNum;
	}

	public void setHisOrdNum(String hisOrdNum) {
		this.hisOrdNum = hisOrdNum;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
}
