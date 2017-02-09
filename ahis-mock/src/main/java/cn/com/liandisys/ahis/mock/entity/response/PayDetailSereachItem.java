package cn.com.liandisys.ahis.mock.entity.response;

public class PayDetailSereachItem {

	private String itemName;
	private String itemType;
	private String itemUnit;
	private double itemPrice;
	private String itemSpec;
	private int itemNumber;
	private double itemTotalFee;

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

	public String getItemUnit() {
		return itemUnit;
	}

	public void setItemUnit(String itemUnit) {
		this.itemUnit = itemUnit;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemSpec() {
		return itemSpec;
	}

	public void setItemSpec(String itemSpec) {
		this.itemSpec = itemSpec;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}

	public double getItemTotalFee() {
		return itemTotalFee;
	}

	public void setItemTotalFee(double itemTotalFee) {
		this.itemTotalFee = itemTotalFee;
	}
}
