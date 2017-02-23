package cn.com.liandisys.ahis.webapp.his.entity.response;

/**
 * 住院费用汇总查询 Response的Item
 * 
 * @author xuyue
 *
 */
public class HospitalizationFeeItem {

	/** 项目名称 */
	private String itemName;
	/** 项目类别/费别 如：药费、检查费、材料费 */
	private String itemType;
	/** 单价 单位：分 */
	private String itemPrice;
	/** 规格 */
	private String itemSpec;
	/** 数量 */
	private String itemNumber;
	/** 项目价格合计 单位：分 */
	private String itemTotalFee;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemTotalFee() {
		return itemTotalFee;
	}

	public void setItemTotalFee(String itemTotalFee) {
		this.itemTotalFee = itemTotalFee;
	}

}
