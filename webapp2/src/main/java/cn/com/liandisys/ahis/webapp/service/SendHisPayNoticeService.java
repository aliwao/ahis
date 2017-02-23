package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBException;

import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointPaymentBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.ClinicPayNoticeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.DepositPayNoticeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointPaymentBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.ClinicPayNoticeBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DepositPayNoticeBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.factory.AppointPaymentHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.ClinicPayNoticeExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.DepositPayNoticeHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractAppointPaymentHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractClinicPayNoticeBaseHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDepositPayNoticeHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.mapper.PaymentRecordMapper;

@Service
public class SendHisPayNoticeService {

	/** logger */
	private static final Logger logger = LoggerFactory.getLogger(SendHisPayNoticeService.class);

	@Autowired
	private DepositPayNoticeHisExecuteLogicFactory hospitalizationFeeHisExecuteLogicFactory;
	@Autowired
	private AppointPaymentHisExecuteLogicFactory appointPaymentHisExecuteLogicFactory;
	@Autowired
	private ClinicPayNoticeExecuteLogicFactory clinicPayNoticeExecuteLogicFactory;
	@Autowired
	private PaymentRecordMapper mapper;

	public PaymentRecordDto getPaymentRecord(String paymentNo) {
		return mapper.getPaymentRecord(paymentNo);
	}

	/**
	 * 押金补缴 通知his mock。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号
	 * @return 科室信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public DepositPayNoticeBaseHisResponse sendHisDepositPayNotice(DepositPayNoticeBaseHisRequest request) {
		AbstractDepositPayNoticeHisExecuteLogic logic = hospitalizationFeeHisExecuteLogicFactory.getLogic();
		DepositPayNoticeBaseHisResponse respone = logic.execute(request);
		return respone;
	}

	/**
	 * 预约支付 通知his mock。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号
	 * @return 科室信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public AppointPaymentBaseHisResponse sendHisRegisterPayNotice(AppointPaymentBaseHisRequest request) {
		AbstractAppointPaymentHisExecuteLogic logic = appointPaymentHisExecuteLogicFactory.getLogic();
		AppointPaymentBaseHisResponse respone = logic.execute(request);
		return respone;
	}

	/**
	 * 门诊缴费支付 通知his mock。
	 * 
	 * @param request
	 *            诊疗卡类型、诊疗卡号
	 * @return 科室信息
	 * @throws UnsupportedEncodingException
	 * @throws JAXBException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping
	public ClinicPayNoticeBaseHisResponse sendHisClinicPayNotice(ClinicPayNoticeBaseHisRequest request) {
		AbstractClinicPayNoticeBaseHisExecuteLogic logic=clinicPayNoticeExecuteLogicFactory.getLogic();
		ClinicPayNoticeBaseHisResponse respone= logic.execute(request);
		return respone;
	}

	/**
	 * 更新通知状态
	 * 
	 * @param PaymentNo
	 */
	public void updateNoticeState(String PaymentNo) {
		mapper.updatePaymentNoticeByKey(PaymentNo, "1");
	}

}
