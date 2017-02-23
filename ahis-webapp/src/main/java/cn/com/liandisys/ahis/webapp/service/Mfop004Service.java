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

import cn.com.liandisys.ahis.webapp.entity.PayDetailEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop004Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.PayDetailSereachItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.PayDetailSereachResponse;


/**
 * 缴费明细Service。
 * 
 */
@Service
public class Mfop004Service {

	private static final Logger logger = LoggerFactory.getLogger(Mfop004Service.class);

	/**
	 * 缴费明细初期化。
	 * 
	 */
	public Mfop004Form init(Mfop004Form mfop004Form, int hisOrdNum, String patCardNo, String patCardType) {
		List<PayDetailSereachItem> itemList = new ArrayList<>();

		try {
			itemList.addAll(payDetailSereach(hisOrdNum, patCardNo, patCardType));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<PayDetailEntity> detailList = new ArrayList<>();
		for (PayDetailSereachItem detail : itemList) {
			PayDetailEntity payDetail = new PayDetailEntity();
			payDetail.setType(detail.getItemType());
			payDetail.setName(detail.getItemName());
			payDetail.setPrice(detail.getItemPrice());
			payDetail.setSpec(detail.getItemSpec());
			payDetail.setNumber(detail.getItemNumber());
			payDetail.setTotalAmt(detail.getItemTotalFee());
			payDetail.setMedInsAmt(0.00);
			payDetail.setSelfAmt(detail.getItemTotalFee());

			detailList.add(payDetail);
		}

		mfop004Form.setDetailList(detailList);

		return mfop004Form;
	}

	/**
	 * 2.1.6.2. 门诊待缴费记录明细查询处理。
	 * 
	 */
	public List<PayDetailSereachItem> payDetailSereach(int hisOrdNum, String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		JSONObject requestJson = new JSONObject();
		requestJson.put("hisOrdNum", hisOrdNum);
		requestJson.put("patCardNo", patCardNo);
		requestJson.put("patCardType", patCardType);
		JSONObject responeJson = HisHttpJson.executeHisApi("MZDJFJLMXCX", requestJson);
		PayDetailSereachResponse respone = HisHttpJson.convJsonToBean(responeJson, PayDetailSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<PayDetailSereachItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}
}
