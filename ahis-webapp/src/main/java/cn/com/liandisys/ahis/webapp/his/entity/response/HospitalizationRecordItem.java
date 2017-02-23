package cn.com.liandisys.ahis.webapp.his.entity.response;

/**
 * 住院记录查询 Response的Item
 * 
 * @author xuyue
 *
 */
public class HospitalizationRecordItem {

	/** 住院号 */
	private String admissionNum;
	/** 住院科室 */
	private String deptName;
	/** 病床号 */
	private String bedNo;
	/** 住院状态 */
	private String status;
	/** 入院日期 */
	private String inDate;
	/** 出院日期 */
	private String outDate;
	/** 住院总费用 */
	private String totalFee;
	/** 住院押金余额 */
	private String balance;
	/** 其他说明 */
	private String otherDesc;

	public String getAdmissionNum() {
		return admissionNum;
	}

	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getOtherDesc() {
		return otherDesc;
	}

	public void setOtherDesc(String otherDesc) {
		this.otherDesc = otherDesc;
	}

}
