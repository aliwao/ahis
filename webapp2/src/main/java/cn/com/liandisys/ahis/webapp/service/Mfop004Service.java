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

import cn.com.liandisys.ahis.webapp.entity.PayDetailEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop004Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PaymentDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PaymentDetailBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PaymentDetailBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.PaymentDetailHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPaymentDetailHisExecuteLogic;

/**
 * 缴费明细Service。
 * 
 */
@Service
public class Mfop004Service {

	@Autowired
	private PaymentDetailHisExecuteLogicFactory paymentDetailHisExecuteLogicFactory;

	private static final Logger logger = LoggerFactory.getLogger(Mfop004Service.class);

	/**
	 * 缴费明细初期化。
	 * 
	 */
	public Mfop004Form init(Mfop004Form mfop004Form, int hisOrdNum, String patCardNo, String patCardType) {
		List<PaymentDetailBaseItem> itemList = new ArrayList<>();

		try {
			itemList.addAll(payDetailSereach(hisOrdNum, patCardNo, patCardType));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<PayDetailEntity> detailList = new ArrayList<>();
		for (PaymentDetailBaseItem detail : itemList) {
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
	public List<PaymentDetailBaseItem> payDetailSereach(int hisOrdNum, String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		AbstractPaymentDetailHisExecuteLogic logic = paymentDetailHisExecuteLogicFactory.getLogic();
		PaymentDetailBaseHisRequest request = new PaymentDetailBaseHisRequest();
		request.setHisOrdNum(hisOrdNum);
		request.setPatCardNo(patCardNo);
		request.setPatCardType(patCardType);

		PaymentDetailBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<PaymentDetailBaseItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}
}
