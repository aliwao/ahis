package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.his.entity.response.BaseResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.DepositPayNoticeResponse;
import cn.com.liandisys.ahis.webapp.service.SendHisPayNoticeService;

/**
 * 平台通知his支付结果 组件。
 */
@RestController
@RequestMapping("rest/his_paynotice/*")
public class SendHisPayNoticeController {

	@Autowired
	private SendHisPayNoticeService service;

	@RequestMapping(value = "send")
	public String send(@RequestParam(name = "paymentNo") String paymentNo) {

		String type = paymentNo.substring(0, 1);

		PaymentRecordDto dto = service.getPaymentRecord(paymentNo);
		if (dto.getPaymentNotice().equals("1")) {
			return "";
		}
		String retcode = null;
		if ("1".equals(type) && dto != null) {
			retcode = registerPayHisNotice(dto);
		} else if ("2".equals(type) && dto != null) {
			retcode = depositHisNotice(dto);
		} else if ("3".equals(type) && dto != null) {
			retcode = clinicPayHisNotice(dto);
		}
		System.out.println("!!!"+retcode);
		if ("0".equals(retcode)) {
			service.updateNoticeState(paymentNo);
		}
		return "";
	}

	/**
	 * 住院押金补缴 通知his。
	 */
	private String depositHisNotice(PaymentRecordDto dto) {
		String ret = null;
		JSONObject json = new JSONObject();
		json.put("patCardType", "1");
		json.put("patCardNo", "1234567");
		json.put("psOrdNum", dto.getHisOrdNum());
		json.put("payMode", "YFK");
		json.put("payAmt", dto.getPayFee() * 100);
		json.put("agtOrdNum", dto.getPaymentNo());
		json.put("payTime", dto.getPaidDate());

			DepositPayNoticeResponse response = service.sendHisDepositPayNotice(json);
			ret = response.getResultCode();

		return ret;
	}

	/**
	 * 预约支付 通知his。
	 */
	private String registerPayHisNotice(PaymentRecordDto dto) {

		String ret = null;
		JSONObject json = new JSONObject();
		json.put("hisOrdNum", dto.getHisOrdNum());
		json.put("psOrdNum", dto.getPaymentNo());
		json.put("payMode", "YFK");
		json.put("payAmt", dto.getPayFee() * 100);
		json.put("agtOrdNum", dto.getPaymentNo());
		json.put("payTime", dto.getPaidDate());

			BaseResponse response = service.sendHisRegisterPayNotice(json);
			ret = response.getResultCode();

		return ret;
	}

	/**
	 * 门诊缴费订单支付 通知his。
	 */
	private String clinicPayHisNotice(PaymentRecordDto dto) {

		String ret = null;
		JSONObject json = new JSONObject();
		json.put("patCardType", "1");
		json.put("patCardNo", "1234567");
		json.put("hisOrdNum", dto.getHisOrdNum());
		json.put("psOrdNum", dto.getPaymentNo());
		json.put("payMode", "YFK");
		json.put("payAmt", dto.getPayFee() * 100);
		json.put("agtOrdNum", dto.getPaymentNo());
		json.put("payTime", dto.getPaidDate());

			BaseResponse response = service.sendHisClinicPayNotice(json);
			ret = response.getResultCode();

		return ret;
	}

}
