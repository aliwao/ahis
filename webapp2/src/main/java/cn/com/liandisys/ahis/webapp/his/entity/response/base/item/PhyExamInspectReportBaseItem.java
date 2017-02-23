package cn.com.liandisys.ahis.webapp.his.entity.response.base.item;

public class PhyExamInspectReportBaseItem {

	// 检验报告ID
	private String inspectItemId;
	// 检验报告名称
	private String inspectitemName;
	// 检验报告结果
	private String result;
	// 参考范围
	private String refRange;
	// 结果异常提示
	private String abnormal;
	// 单位
	private String unit;

	public String getInspectItemId() {
		return inspectItemId;
	}

	public void setInspectItemId(String inspectItemId) {
		this.inspectItemId = inspectItemId;
	}

	public String getInspectitemName() {
		return inspectitemName;
	}

	public void setInspectitemName(String inspectitemName) {
		this.inspectitemName = inspectitemName;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
