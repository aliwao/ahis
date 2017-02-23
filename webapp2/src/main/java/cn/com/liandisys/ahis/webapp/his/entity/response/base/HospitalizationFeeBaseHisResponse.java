package cn.com.liandisys.ahis.webapp.his.entity.response.base;

import java.util.List;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.HospitalizationFeeBaseItem;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 住院费用清单查询 Response。
 * 
 * @author xuyue
 *
 */
public class HospitalizationFeeBaseHisResponse extends AbstractHisResponse {

	/** serialVersionUID */
	private static final long serialVersionUID = -5869838484097232868L;

	@JSONField(name="item")
	private List<HospitalizationFeeBaseItem> itemList;
	/** 清单开始日期 */
	private String beginDate;
	/** 清单结束日期 */
	private String endDate;
	/** 入院日期 */
	private String inDate;
	/** 出院日期 */
	private String outDate;
	/** 在院天数 */
	private String inDays;
	/** 住院科室 */
	private String deptName;
	/** 结算类别 */
	private String settleType;
	/** 病床号 */
	private String bedNo;
	/** 费用总金额 单位：分 */
	private String totalFee;
	/** 甲类金额 单位：分 */
	private String feeA;
	/** 乙类金额 单位：分 */
	private String feeB;
	/** 丙类金额 单位：分 */
	private String feeC;
	/** 床位费 单位：分 */
	private String bedFee;
	/** 西药费 单位：分 */
	private String westMedFee;
	/** 成药费 单位：分 */
	private String readyMedFee;
	/** 草药费 单位：分 */
	private String herbMedFee;
	/** 诊疗费 单位：分 */
	private String treatFee;

	public List<HospitalizationFeeBaseItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<HospitalizationFeeBaseItem> itemList) {
		this.itemList = itemList;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getInDays() {
		return inDays;
	}

	public void setInDays(String inDays) {
		this.inDays = inDays;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptNames(String deptName) {
		this.deptName = deptName;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getFeeA() {
		return feeA;
	}

	public void setFeeA(String feeA) {
		this.feeA = feeA;
	}

	public String getFeeB() {
		return feeB;
	}

	public void setFeeB(String feeB) {
		this.feeB = feeB;
	}

	public String getFeeC() {
		return feeC;
	}

	public void setFeeC(String feeC) {
		this.feeC = feeC;
	}

	public String getBedFee() {
		return bedFee;
	}

	public void setBedFee(String bedFee) {
		this.bedFee = bedFee;
	}

	public String getWestMedFee() {
		return westMedFee;
	}

	public void setWestMedFee(String westMedFee) {
		this.westMedFee = westMedFee;
	}

	public String getReadyMedFee() {
		return readyMedFee;
	}

	public void setReadyMedFee(String readyMedFee) {
		this.readyMedFee = readyMedFee;
	}

	public String getHerbMedFee() {
		return herbMedFee;
	}

	public void setHerbMedFee(String herbMedFee) {
		this.herbMedFee = herbMedFee;
	}

	public String getTreatFee() {
		return treatFee;
	}

	public void setTreatFee(String treatFee) {
		this.treatFee = treatFee;
	}
}
