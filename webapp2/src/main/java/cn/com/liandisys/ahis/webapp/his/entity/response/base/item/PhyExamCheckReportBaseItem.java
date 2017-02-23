package cn.com.liandisys.ahis.webapp.his.entity.response.base.item;

public class PhyExamCheckReportBaseItem {

	// 检查项目ID
	private String checkItemId;
	// 检查项目名称
	private String checkItemName;
	// 检查结果
	private String checkResult;

	public String getCheckItemId() {
		return checkItemId;
	}

	public void setCheckItemId(String checkItemId) {
		this.checkItemId = checkItemId;
	}

	public String getCheckItemName() {
		return checkItemName;
	}

	public void setCheckItemName(String checkItemName) {
		this.checkItemName = checkItemName;
	}

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

}
