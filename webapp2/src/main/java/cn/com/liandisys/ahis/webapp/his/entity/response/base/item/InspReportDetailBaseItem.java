package cn.com.liandisys.ahis.webapp.his.entity.response.base.item;

public class InspReportDetailBaseItem {

	// 项目名称
	private String itemName;
	// 结果
	private String result;
	// 参考范围
	private String refRange;
	// 结果异常提示
	private String abnormal;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getRefRange() {
		return refRange;
	}

	public void setRefRange(String refRange) {
		this.refRange = refRange;
	}

	public String getAbnormal() {
		return abnormal;
	}

	public void setAbnormal(String abnormal) {
		this.abnormal = abnormal;
	}

}
