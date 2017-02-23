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

import cn.com.liandisys.ahis.webapp.form.Rsrs003Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.PhyExamInspectReportItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.PhyExamItemDetailSereachResponse;


@Service
public class Rsrs003Service {

	private static final Logger logger = LoggerFactory.getLogger(Rsrs003Service.class);

	/**
	 * 体检项目详情查询。
	 * 
	 * @param rsrs003Form
	 * @param checkId
	 * @param itemId
	 * @return Rsrs003Form
	 */
	public Rsrs003Form init(Rsrs003Form rsrs003Form, String checkId, String itemId) {

		// 体检项目详情查询
		PhyExamItemDetailSereachResponse phyExamItemDetail = new PhyExamItemDetailSereachResponse();

		JSONObject phyExamItemDetailRequestJson = new JSONObject();
		phyExamItemDetailRequestJson.put("patCardNo", "0001");
		phyExamItemDetailRequestJson.put("patName", "王大");
		phyExamItemDetailRequestJson.put("checkId", checkId);
		phyExamItemDetailRequestJson.put("itemId", "王大");
		try {
			phyExamItemDetail = getPhyExamItemDetail(phyExamItemDetailRequestJson);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		if (phyExamItemDetail != null) {
			rsrs003Form.setDeptSummary(phyExamItemDetail.getDeptSummary());

			List<PhyExamInspectReportItem> newResult = new ArrayList<>();
			for (PhyExamInspectReportItem item : phyExamItemDetail.getInspectItemList()) {
				if ("0".equals(item.getAbnormal())) {
					item.setAbnormal("正常");

				} else if ("1".equals(item.getAbnormal())) {
					item.setAbnormal("偏高");

				} else if ("2".equals(item.getAbnormal())) {
					item.setAbnormal("偏低");
				}
				newResult.add(item);
			}

			rsrs003Form.setInspectList(newResult);
			rsrs003Form.setCheckList(phyExamItemDetail.getCheckItemList());
		}

		return rsrs003Form;
	}

	/**
	 * 体检项目详情查询。
	 * 
	 * @param request
	 * @return PhyExamItemDetailSereachResponse
	 */
	private PhyExamItemDetailSereachResponse getPhyExamItemDetail(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		JSONObject responeJson = HisHttpJson.executeHisApi("TJXMXQCX", requestJosn);
		PhyExamItemDetailSereachResponse respone = HisHttpJson.convJsonToBean(responeJson,
				PhyExamItemDetailSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

}
