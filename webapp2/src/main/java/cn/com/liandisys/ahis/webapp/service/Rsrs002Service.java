package cn.com.liandisys.ahis.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.InspReportDetailEntity;
import cn.com.liandisys.ahis.webapp.entity.InspResultDetailEntity;
import cn.com.liandisys.ahis.webapp.entity.PhyExamReportDetailEntity;
import cn.com.liandisys.ahis.webapp.form.Rsrs002Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspReportDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspResultDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PhyExamReportDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspReportDetailBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspResultDetailBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PhyExamReportDetailBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.InspReportDetailBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamReportDetailBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.InspReportDetailHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.InspResultDetailHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.PhyExamReportDetailHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspReportDetailHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspResultDetailHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPhyExamReportDetailHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


@Service
public class Rsrs002Service {
	
	@Autowired
	private InspResultDetailHisExecuteLogicFactory inspResultDetailHisExecuteLogicFactory;
	@Autowired
	private InspReportDetailHisExecuteLogicFactory inspReportDetailHisExecuteLogicFactory;
	@Autowired
	private PhyExamReportDetailHisExecuteLogicFactory phyExamReportDetailHisExecuteLogicFactory;

	private static final Logger logger = LoggerFactory.getLogger(Rsrs002Service.class);

	/**
	 * 检查结果详情查询。
	 * 
	 * @param rsrs002Form
	 * @param checkId
	 * @param reportType
	 * @return Rsrs002Form
	 */
	public Rsrs002Form init(Rsrs002Form rsrs002Form, String checkId, String reportType) {

		if ("1".equals(reportType)) {

			// 检查结果详情查询
			InspResultDetailBaseHisResponse inspResultDetail = new InspResultDetailBaseHisResponse();

			JSONObject inspResultDetailRequestJson = new JSONObject();
			inspResultDetailRequestJson.put("patCardNo", "0001");
			inspResultDetailRequestJson.put("patCardType", "1");
			inspResultDetailRequestJson.put("checkId", checkId);
			inspResultDetail = getInspResultDetail(inspResultDetailRequestJson);

			if (inspResultDetail != null) {
				InspResultDetailEntity entity = new InspResultDetailEntity();
				entity.setCheckId(inspResultDetail.getCheckId());
				entity.setCheckMethod(inspResultDetail.getCheckMethod());
				entity.setCheckName(inspResultDetail.getCheckName());
				entity.setCheckPart(inspResultDetail.getCheckPart());
				entity.setCheckSituation(inspResultDetail.getCheckSituation());
				entity.setDeptName(inspResultDetail.getDeptName());
				entity.setDoctorName(inspResultDetail.getDoctorName());
				entity.setOption(inspResultDetail.getOption());
				entity.setReportTime(inspResultDetail.getReportTime());
				entity.setAdvice(inspResultDetail.getAdvice());
				rsrs002Form.setInspResultDetail(entity);
			}
		} else if ("2".equals(reportType)) {

			// 检验报告详情查询
			InspReportDetailBaseHisResponse inspReportDetail = new InspReportDetailBaseHisResponse();

			JSONObject inspReportDetailRequestJson = new JSONObject();
			inspReportDetailRequestJson.put("patCardNo", "0001");
			inspReportDetailRequestJson.put("patCardType", "1");
			inspReportDetailRequestJson.put("checkId", checkId);
			inspReportDetail = getInspReportDetail(inspReportDetailRequestJson);

			if (inspReportDetail != null) {
				InspReportDetailEntity entity = new InspReportDetailEntity();
				entity.setInspectId(inspReportDetail.getInspectId());
				entity.setInspectName(inspReportDetail.getInspectName());
				entity.setInspectTime(inspReportDetail.getInspectTime());
				entity.setDeptName(inspReportDetail.getDeptName());
				entity.setDoctorName(inspReportDetail.getDoctorName());
				entity.setReportTime(inspReportDetail.getReportTime());

				List<InspReportDetailBaseItem> result = new ArrayList<>();
				List<InspReportDetailBaseItem> newResult = new ArrayList<>();
				inspReportDetail.getItemList().forEach(item -> {
					result.add(item);
				});
				for (InspReportDetailBaseItem item : result) {
					if ("0".equals(item.getAbnormal())) {
						item.setAbnormal("正常");

					} else if ("1".equals(item.getAbnormal())) {
						item.setAbnormal("偏高");

					} else if ("2".equals(item.getAbnormal())) {
						item.setAbnormal("偏低");
					}
					newResult.add(item);

				}
				entity.setInspReportDetailList(newResult);

				rsrs002Form.setInspReportDetail(entity);
			}
		} else if ("3".equals(reportType)) {

			// 体检报告详情查询
			LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();

			PhyExamReportDetailBaseHisResponse phyExamDetail = new PhyExamReportDetailBaseHisResponse();

			JSONObject phyExamDetailRequestJson = new JSONObject();
			phyExamDetailRequestJson.put("patCardNo", "0001");
			phyExamDetailRequestJson.put("patName", userInfo.getFullName());
			phyExamDetailRequestJson.put("checkId", checkId);
			phyExamDetail = getPhyExamReportDetail(phyExamDetailRequestJson);

			if (phyExamDetail != null) {
				PhyExamReportDetailEntity entity = new PhyExamReportDetailEntity();
				entity.setPatName(phyExamDetail.getPatName());
				entity.setPatSex(phyExamDetail.getPatSex());
				entity.setPhyExamNo(phyExamDetail.getPhyExamNo());
				entity.setDeptName(phyExamDetail.getDeptName());
				entity.setDoctorName(phyExamDetail.getDoctorName());
				entity.setPhyExamTime(phyExamDetail.getPhyExamTime());
				entity.setPhyExamReview(phyExamDetail.getPhyExamReview());
				entity.setDoctorAdvice(phyExamDetail.getDoctorAdvice());

				List<PhyExamReportDetailBaseItem> result = new ArrayList<>();
				phyExamDetail.getItemList().forEach(item -> {
					result.add(item);
				});
				entity.setItemList(result);

				rsrs002Form.setPhyExamReportDetail(entity);
			}

		}

		return rsrs002Form;
	}

	/**
	 * 检查结果详情查询。
	 * 
	 * @param request
	 * @return InspResultDetailBaseHisResponse
	 */
	private InspResultDetailBaseHisResponse getInspResultDetail(JSONObject requestJosn) {

		AbstractInspResultDetailHisExecuteLogic logic = inspResultDetailHisExecuteLogicFactory.getLogic();
		InspResultDetailBaseHisRequest request = new InspResultDetailBaseHisRequest();
		request.setPatCardNo("0001");
		request.setPatCardType("1");
		request.setCheckId(requestJosn.get("checkId").toString());
		InspResultDetailBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

	/**
	 * 检验报告详情查询。
	 * 
	 * @param request
	 * @return InspReportDetailBaseHisResponse
	 */
	private InspReportDetailBaseHisResponse getInspReportDetail(JSONObject requestJosn) {

		AbstractInspReportDetailHisExecuteLogic logic = inspReportDetailHisExecuteLogicFactory.getLogic();
		InspReportDetailBaseHisRequest request = new InspReportDetailBaseHisRequest();
		request.setPatCardNo("0001");
		request.setPatCardType("1");
		request.setInspectId(requestJosn.get("checkId").toString());
		InspReportDetailBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

	/**
	 * 体检报告详情查询。
	 * 
	 * @param request
	 * @return PhyExamReportDetailBaseHisResponse
	 */
	private PhyExamReportDetailBaseHisResponse getPhyExamReportDetail(JSONObject requestJosn) {

		AbstractPhyExamReportDetailHisExecuteLogic logic = phyExamReportDetailHisExecuteLogicFactory.getLogic();
		PhyExamReportDetailBaseHisRequest request = new PhyExamReportDetailBaseHisRequest();
		request.setPatName(requestJosn.get("patName").toString());
		request.setPatCardNo(requestJosn.get("patCardNo").toString());
		request.setPhyExamId(requestJosn.get("checkId").toString());
		PhyExamReportDetailBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

}
