package cn.com.liandisys.ahis.webapp.form;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisForm;
import cn.com.liandisys.ahis.webapp.entity.InspReportDetailEntity;
import cn.com.liandisys.ahis.webapp.entity.InspResultDetailEntity;
import cn.com.liandisys.ahis.webapp.entity.PhyExamReportDetailEntity;

/**
 * 报告详情Form。
 * 
 */
public class Rsrs002Form extends AbstractAhisForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2786680359142093853L;

	/** 检查结果详情 */
	private InspResultDetailEntity inspResultDetail;
	/** 检验报告详情 */
	private InspReportDetailEntity inspReportDetail;
	/** 体检报告详情 */
	private PhyExamReportDetailEntity phyExamReportDetail;
	/** 项目ID */
	private String hidItemId;

	public InspResultDetailEntity getInspResultDetail() {
		return inspResultDetail;
	}

	public void setInspResultDetail(InspResultDetailEntity inspResultDetail) {
		this.inspResultDetail = inspResultDetail;
	}

	public InspReportDetailEntity getInspReportDetail() {
		return inspReportDetail;
	}

	public void setInspReportDetail(InspReportDetailEntity inspReportDetail) {
		this.inspReportDetail = inspReportDetail;
	}

	public PhyExamReportDetailEntity getPhyExamReportDetail() {
		return phyExamReportDetail;
	}

	public void setPhyExamReportDetail(PhyExamReportDetailEntity phyExamReportDetail) {
		this.phyExamReportDetail = phyExamReportDetail;
	}

	public String getHidItemId() {
		return hidItemId;
	}

	public void setHidItemId(String hidItemId) {
		this.hidItemId = hidItemId;
	}

}
