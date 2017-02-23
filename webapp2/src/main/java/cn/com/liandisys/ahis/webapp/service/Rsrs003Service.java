package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.form.Rsrs003Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PhyExamItemDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PhyExamItemDetailBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PhyExamInspectReportBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.PhyExamItemDetailHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPhyExamItemDetailHisExecuteLogic;


@Service
public class Rsrs003Service {
	
	@Autowired
	private PhyExamItemDetailHisExecuteLogicFactory phyExamItemDetailHisExecuteLogicFactory;

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
		PhyExamItemDetailBaseHisResponse phyExamItemDetail = new PhyExamItemDetailBaseHisResponse();

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

			List<PhyExamInspectReportBaseItem> newResult = new ArrayList<>();
			for (PhyExamInspectReportBaseItem item : phyExamItemDetail.getInspectItemList()) {
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
	 * @return PhyExamItemDetailBaseHisResponse
	 */
	private PhyExamItemDetailBaseHisResponse getPhyExamItemDetail(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {

		AbstractPhyExamItemDetailHisExecuteLogic logic = phyExamItemDetailHisExecuteLogicFactory.getLogic();
		PhyExamItemDetailBaseHisRequest request = new PhyExamItemDetailBaseHisRequest();
		request.setPatName(requestJosn.get("patName").toString());
		request.setPatCardNo(requestJosn.get("patCardNo").toString());
		request.setPhyExamId(requestJosn.get("checkId").toString());
		request.setItemId(requestJosn.get("itemId").toString());
		PhyExamItemDetailBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		return respone;
	}

}
