package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.entity.InspReportEntity;
import cn.com.liandisys.ahis.webapp.entity.InspResultEntity;
import cn.com.liandisys.ahis.webapp.entity.PhyExamReportEntity;
import cn.com.liandisys.ahis.webapp.form.Rsrs001Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspReportListBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspResultListBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PhyExamReportListBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspReportListBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspResultListBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PhyExamReportListBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.InspReportListBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.InspResultListBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamReportListBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.InspReportListHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.InspResultListHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.PhyExamReportListHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspReportListHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspResultListHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPhyExamReportListHisExecuteLogic;

@Service
public class Rsrs001Service {

	@Autowired
	private InspResultListHisExecuteLogicFactory inspResultListHisExecuteLogicFactory;
	@Autowired
	private InspReportListHisExecuteLogicFactory inspReportListHisExecuteLogicFactory;
	@Autowired
	private PhyExamReportListHisExecuteLogicFactory phyExamReportListHisExecuteLogicFactory;

	private static final Logger logger = LoggerFactory.getLogger(Rsrs001Service.class);

	/**
	 * 画面初期化
	 * 
	 * @param Rsrs001Form
	 * @return Rsrs001Form
	 */
	public Rsrs001Form init(Rsrs001Form rsrs001Form) {

		// 检查报告列表查询
		List<InspResultListBaseItem> inspResultList = new ArrayList<>();

		JSONObject resultRequestJson = new JSONObject();
		resultRequestJson.put("patCardNo", "0001");
		resultRequestJson.put("patCardType", "1");
		try {
			inspResultList.addAll(getInspResultList(resultRequestJson));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<InspResultEntity> inspResult = new ArrayList<>();
		for (InspResultListBaseItem resultItem : inspResultList) {
			InspResultEntity inspResultEntity = new InspResultEntity();
			inspResultEntity.setCheckId(resultItem.getCheckId());
			inspResultEntity.setCheckName(resultItem.getCheckName());
			if ("1".equals(resultItem.getCheckStatus())) {
				inspResultEntity.setCheckStatus("未出报告");
			} else if ("2".equals(resultItem.getCheckStatus())) {
				inspResultEntity.setCheckStatus("已出报告，未审核");
			} else if ("3".equals(resultItem.getCheckStatus())) {
				inspResultEntity.setCheckStatus("已出报告，已审核");
			}
			inspResultEntity.setCheckTime(resultItem.getCheckTime());
			inspResultEntity.setDeptCode(resultItem.getDeptCode());
			inspResultEntity.setDeptName(resultItem.getDeptName());
			inspResultEntity.setDoctorCode(resultItem.getDoctorCode());
			inspResultEntity.setDoctorName(resultItem.getDoctorName());
			inspResultEntity.setExamTime(resultItem.getExamTime());
			inspResultEntity.setExeDeptCode(resultItem.getExeDeptCode());
			inspResultEntity.setExeDeptName(resultItem.getExeDeptName());
			inspResultEntity.setReporter(resultItem.getReporter());
			inspResultEntity.setReportTime(resultItem.getReportTime());

			inspResult.add(inspResultEntity);
		}
		rsrs001Form.setInspResultList(inspResult);

		// 检验报告列表查询
		List<InspReportListBaseItem> inspReportList = new ArrayList<>();

		JSONObject reportRequestJson = new JSONObject();
		reportRequestJson.put("patCardNo", "0001");
		reportRequestJson.put("patCardType", "1");
		try {
			inspReportList.addAll(getInspReportList(reportRequestJson));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<InspReportEntity> inspReport = new ArrayList<>();
		for (InspReportListBaseItem reportItem : inspReportList) {
			InspReportEntity inspReportEntity = new InspReportEntity();
			inspReportEntity.setInspectId(reportItem.getInspectId());
			inspReportEntity.setInspectName(reportItem.getInspectName());
			if ("1".equals(reportItem.getInspectStatus())) {
				inspReportEntity.setInspectStatus("未出报告");
			} else if ("2".equals(reportItem.getInspectStatus())) {
				inspReportEntity.setInspectStatus("已出报告，未审核");
			} else if ("3".equals(reportItem.getInspectStatus())) {
				inspReportEntity.setInspectStatus("已出报告，已审核");
			}
			inspReportEntity.setInspectTime(reportItem.getInspectTime());
			inspReportEntity.setDeptCode(reportItem.getDeptCode());
			inspReportEntity.setDeptName(reportItem.getDeptName());
			inspReportEntity.setDoctorCode(reportItem.getDoctorCode());
			inspReportEntity.setDoctorName(reportItem.getDoctorName());
			inspReportEntity.setExamTime(reportItem.getExamTime());
			inspReportEntity.setExeDeptCode(reportItem.getExeDeptCode());
			inspReportEntity.setExeDeptName(reportItem.getExeDeptName());
			inspReportEntity.setReporter(reportItem.getReporter());
			inspReportEntity.setReportTime(reportItem.getReportTime());

			inspReport.add(inspReportEntity);
		}
		rsrs001Form.setInspReportList(inspReport);

		// 体检报告列表查询
		List<PhyExamReportListBaseItem> phyExamReportList = new ArrayList<>();

		JSONObject phyExamReportRequestJson = new JSONObject();
		phyExamReportRequestJson.put("patCardNo", "0001");
		phyExamReportRequestJson.put("patName", "张三");
		try {
			phyExamReportList.addAll(getPhyExamReportList(phyExamReportRequestJson));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<PhyExamReportEntity> phyExamReport = new ArrayList<>();
		for (PhyExamReportListBaseItem phyExamReportItem : phyExamReportList) {
			PhyExamReportEntity phyExamReportEntity = new PhyExamReportEntity();
			phyExamReportEntity.setPhyExamId(phyExamReportItem.getPhyExamId());
			phyExamReportEntity.setPhyExamName(phyExamReportItem.getPhyExamName());
			phyExamReportEntity.setPhyExamTime(phyExamReportItem.getPhyExamTime());

			phyExamReport.add(phyExamReportEntity);
		}
		rsrs001Form.setPhyExamReportList(phyExamReport);
		return rsrs001Form;
	}

	/**
	 * 检查结果列表查询。
	 * 
	 * @param request
	 * @return List<InspResultListBaseItem>
	 */
	private List<InspResultListBaseItem> getInspResultList(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		Date now = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = format.format(DateUtils.addDays(now, 1));
		String endDate = format.format(DateUtils.addDays(now, 10));

		AbstractInspResultListHisExecuteLogic logic = inspResultListHisExecuteLogicFactory.getLogic();
		InspResultListBaseHisRequest request = new InspResultListBaseHisRequest();
		request.setPatCardNo("0001");
		request.setPatCardType("1");
		request.setBeginDate(beginDate);
		request.setEndDate(endDate);
		InspResultListBaseHisResponse respone = logic.execute(request);

		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<InspResultListBaseItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}

	/**
	 * 检验报告列表查询。
	 * 
	 * @param request
	 * @return List<InspReportListBaseItem>
	 */
	private List<InspReportListBaseItem> getInspReportList(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		Date now = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = format.format(DateUtils.addDays(now, 1));
		String endDate = format.format(DateUtils.addDays(now, 10));
		AbstractInspReportListHisExecuteLogic logic = inspReportListHisExecuteLogicFactory.getLogic();
		InspReportListBaseHisRequest request = new InspReportListBaseHisRequest();
		request.setPatCardNo("0001");
		request.setPatCardType("1");
		request.setBeginDate(beginDate);
		request.setEndDate(endDate);
		InspReportListBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<InspReportListBaseItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}

	/**
	 * 体检报告列表查询。
	 * 
	 * @param request
	 * @return List<PhyExamReportListBaseItem>
	 */
	private List<PhyExamReportListBaseItem> getPhyExamReportList(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		Date now = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = format.format(DateUtils.addDays(now, 1));
		String endDate = format.format(DateUtils.addDays(now, 10));

		AbstractPhyExamReportListHisExecuteLogic logic = phyExamReportListHisExecuteLogicFactory.getLogic();
		PhyExamReportListBaseHisRequest request = new PhyExamReportListBaseHisRequest();
		request.setPatCardNo("0001");
		request.setPatName("张三");
		request.setBeginDate(beginDate);
		request.setEndDate(endDate);
		PhyExamReportListBaseHisResponse respone = logic.execute(request);

		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<PhyExamReportListBaseItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}

}
