package cn.com.liandisys.ahis.webapp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.PayDetailEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop004Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpClient;
import cn.com.liandisys.ahis.webapp.his.entity.request.PayDetailSereachRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.PayDetailSereachItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.PayDetailSereachResponse;

@Controller
@RequestMapping("/m/mfop004/*")
public class Mfop004Controller extends AbstractAhisController<Mfop004Form> {

	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	/**
	 * 画面初期化处理。
	 * 
	 * @param mfop004Form
	 */
	@RequestMapping("init")
	public String init(@ModelAttribute Mfop004Form mfop004Form, HttpServletRequest req, int hisOrdNum, String patCardNo,
			String patCardType) {

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

		return forwardIndex();
	}

	/**
	 * 2.1.6.2. 门诊待缴费记录明细查询处理。
	 * 
	 */
	public List<PayDetailSereachItem> payDetailSereach(int hisOrdNum, String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		PayDetailSereachRequest requestEntity = new PayDetailSereachRequest();
		requestEntity.setHisOrdNum(hisOrdNum);
		requestEntity.setPatCardNo(patCardNo);
		requestEntity.setPatCardType(patCardType);
		PayDetailSereachResponse respone = HisHttpClient.executeHisApi("/his/payDetailSereach", requestEntity,
				PayDetailSereachRequest.class, PayDetailSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<PayDetailSereachItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}
}
