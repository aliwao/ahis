package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointPaymentBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.ClinicPayNoticeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.DepositPayNoticeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointPaymentBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.ClinicPayNoticeBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DepositPayNoticeBaseHisResponse;
import cn.com.liandisys.ahis.webapp.service.SendHisPayNoticeService;
import cn.com.liandisys.common.util.DateFormatUtil;

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
		System.out.println("!!!" + retcode);
		if ("0".equals(retcode)) {
			service.updateNoticeState(paymentNo);
		}
		return "";
	}

	/**
	 * 住院押金补缴 通知his。
	 */
	private String depositHisNotice(PaymentRecordDto dto) {
		DepositPayNoticeBaseHisRequest request = new DepositPayNoticeBaseHisRequest();
		request.setPatCardType("1");
		request.setPatCardNo("1234567");
		request.setPsOrdNum(dto.getHisOrdNum().toString());
		request.setPayMode("YFK");
		request.setPayAmt(String.valueOf(dto.getPayFee() * 100));
		request.setAgtOrdNum(dto.getPaymentNo());
		request.setPayTime(dto.getPaidDate().toString());

		DepositPayNoticeBaseHisResponse response = service.sendHisDepositPayNotice(request);
		return response.getResultCode();
	}

	/**
	 * 预约支付 通知his。
	 */
	private String registerPayHisNotice(PaymentRecordDto dto) {

		AppointPaymentBaseHisRequest request = new AppointPaymentBaseHisRequest();
		request.setHisOrdNum(String.valueOf(dto.getHisOrdNum()));
		request.setPsOrdNum(dto.getPaymentNo());
		request.setPayMode("YFK");
		request.setPayAmt(String.valueOf(dto.getPayFee() * 100));
		request.setAgtOrdNum(dto.getPaymentNo());
		request.setPayTime(DateFormatUtil.formatDateToBarYmd(dto.getPaidDate()));
		AppointPaymentBaseHisResponse response = service.sendHisRegisterPayNotice(request);
		return response.getResultCode();
	}

	/**
	 * 门诊缴费订单支付 通知his。
	 */
	private String clinicPayHisNotice(PaymentRecordDto dto) {
		ClinicPayNoticeBaseHisRequest request = new ClinicPayNoticeBaseHisRequest();
		request.setPatCardType("1");
		request.setPatCardNo("1234567");
		request.setHisOrdNum(String.valueOf(dto.getHisOrdNum()));
		request.setPsOrdNum(dto.getPaymentNo());
		request.setPayMode("YFK");
		request.setPayAmt(String.valueOf(dto.getPayFee() * 100));
		request.setAgtOrdNum(dto.getPaymentNo());
		request.setPayTime(DateFormatUtil.formatDateToBarYmd(dto.getPaidDate()));
		ClinicPayNoticeBaseHisResponse response = service.sendHisClinicPayNotice(request);
		return response.getResultCode();
	}

}
