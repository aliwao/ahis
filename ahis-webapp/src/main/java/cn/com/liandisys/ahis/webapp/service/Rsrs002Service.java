package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.InspReportDetailEntity;
import cn.com.liandisys.ahis.webapp.entity.InspResultDetailEntity;
import cn.com.liandisys.ahis.webapp.entity.PhyExamReportDetailEntity;
import cn.com.liandisys.ahis.webapp.form.Rsrs002Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.InspReportDetailSereachItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.InspReportDetailSereachResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.InspResultDetailSereachResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.PhyExamReportDetailSereachItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.PhyExamReportDetailSereachResponse;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


@Service
public class Rsrs002Service {

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
			InspResultDetailSereachResponse inspResultDetail = new InspResultDetailSereachResponse();

			JSONObject inspResultDetailRequestJson = new JSONObject();
			inspResultDetailRequestJson.put("patCardNo", "0001");
			inspResultDetailRequestJson.put("patCardType", "1");
			inspResultDetailRequestJson.put("checkId", checkId);
			try {
				inspResultDetail = getInspResultDetail(inspResultDetailRequestJson);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

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
			InspReportDetailSereachResponse inspReportDetail = new InspReportDetailSereachResponse();

			JSONObject inspReportDetailRequestJson = new JSONObject();
			inspReportDetailRequestJson.put("patCardNo", "0001");
			inspReportDetailRequestJson.put("patCardType", "1");
			inspReportDetailRequestJson.put("checkId", checkId);
			try {
				inspReportDetail = getInspReportDetail(inspReportDetailRequestJson);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			if (inspReportDetail != null) {
				InspReportDetailEntity entity = new InspReportDetailEntity();
				entity.setInspectId(inspReportDetail.getInspectId());
				entity.setInspectName(inspReportDetail.getInspectName());
				entity.setInspectTime(inspReportDetail.getInspectTime());
				entity.setDeptName(inspReportDetail.getDeptName());
				entity.setDoctorName(inspReportDetail.getDoctorName());
				entity.setReportTime(inspReportDetail.getReportTime());

				List<InspReportDetailSereachItem> result = new ArrayList<>();
				List<InspReportDetailSereachItem> newResult = new ArrayList<>();
				inspReportDetail.getItemList().forEach(item -> {
					result.add(item);
				});
				for (InspReportDetailSereachItem item : result) {
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

			PhyExamReportDetailSereachResponse phyExamDetail = new PhyExamReportDetailSereachResponse();

			JSONObject phyExamDetailRequestJson = new JSONObject();
			phyExamDetailRequestJson.put("patCardNo", "0001");
			phyExamDetailRequestJson.put("patName", userInfo.getFullName());
			phyExamDetailRequestJson.put("checkId", checkId);
			try {
				phyExamDetail = getPhyExamReportDetail(phyExamDetailRequestJson);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

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

				List<PhyExamReportDetailSereachItem> result = new ArrayList<>();
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
	 * @return InspResultDetailSereachResponse
	 */
	private InspResultDetailSereachResponse getInspResultDetail(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		JSONObject responeJson = HisHttpJson.executeHisApi("JCJGXQCX", requestJosn);
		InspResultDetailSereachResponse respone = HisHttpJson.convJsonToBean(responeJson,
				InspResultDetailSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

	/**
	 * 检验报告详情查询。
	 * 
	 * @param request
	 * @return InspReportDetailSereachResponse
	 */
	private InspReportDetailSereachResponse getInspReportDetail(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		JSONObject responeJson = HisHttpJson.executeHisApi("JYBGXQCX", requestJosn);
		InspReportDetailSereachResponse respone = HisHttpJson.convJsonToBean(responeJson,
				InspReportDetailSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

	/**
	 * 体检报告详情查询。
	 * 
	 * @param request
	 * @return PhyExamReportDetailSereachResponse
	 */
	private PhyExamReportDetailSereachResponse getPhyExamReportDetail(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		JSONObject responeJson = HisHttpJson.executeHisApi("TJBGXQCX", requestJosn);
		PhyExamReportDetailSereachResponse respone = HisHttpJson.convJsonToBean(responeJson,
				PhyExamReportDetailSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

}
