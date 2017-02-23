package cn.com.liandisys.ahis.webapp.his.entity.response.base;


/**
 * 住院押金补缴支付 Response。
 * 
 * @author xuyue
 *
 */
public class DepositPayNoticeBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = 3274801202131676372L;

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
