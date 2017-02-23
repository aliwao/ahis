package cn.com.liandisys.ahis.webapp.form;

import java.util.List;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.InspReportEntity;
import cn.com.liandisys.ahis.webapp.entity.InspResultEntity;
import cn.com.liandisys.ahis.webapp.entity.PhyExamReportEntity;

/**
 * 报告一览Form。
 * 
 */
public class Rsrs001Form extends AbstractAhisForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2786680359142093853L;

	/** 检查结果list */
	private List<InspResultEntity> inspResultList;
	/** 检验报告list */
	private List<InspReportEntity> inspReportList;
	/** 体检报告list */
	private List<PhyExamReportEntity> phyExamReportList;
	/** 检查ID */
	private String hidCheckId;
	/** 诊疗卡类型 */
	private String hidPatCardType;
	/** 诊疗卡号 */
	private String hidPatCardNo;
	/** 报告类型 */
	private String hidReportType;
	/** 报告有无flag */
	private String hidReportFlag;

	public List<InspResultEntity> getInspResultList() {
		return inspResultList;
	}

	public void setInspResultList(List<InspResultEntity> inspResultList) {
		this.inspResultList = inspResultList;
	}

	public List<InspReportEntity> getInspReportList() {
		return inspReportList;
	}

	public void setInspReportList(List<InspReportEntity> inspReportList) {
		this.inspReportList = inspReportList;
	}

	public List<PhyExamReportEntity> getPhyExamReportList() {
		return phyExamReportList;
	}

	public void setPhyExamReportList(List<PhyExamReportEntity> phyExamReportList) {
		this.phyExamReportList = phyExamReportList;
	}

	public String getHidCheckId() {
		return hidCheckId;
	}

	public void setHidCheckId(String hidCheckId) {
		this.hidCheckId = hidCheckId;
	}

	public String getHidPatCardType() {
		return hidPatCardType;
	}

	public void setHidPatCardType(String hidPatCardType) {
		this.hidPatCardType = hidPatCardType;
	}

	public String getHidPatCardNo() {
		return hidPatCardNo;
	}

	public void setHidPatCardNo(String hidPatCardNo) {
		this.hidPatCardNo = hidPatCardNo;
	}

	public String getHidReportType() {
		return hidReportType;
	}

	public void setHidReportType(String hidReportType) {
		this.hidReportType = hidReportType;
	}

	public String getHidReportFlag() {
		return hidReportFlag;
	}

	public void setHidReportFlag(String hidReportFlag) {
		this.hidReportFlag = hidReportFlag;
	}

}
