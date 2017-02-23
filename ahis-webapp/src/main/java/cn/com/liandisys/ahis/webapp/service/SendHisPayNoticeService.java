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

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.BaseResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.DepositPayNoticeResponse;
import cn.com.liandisys.ahis.webapp.mapper.PaymentRecordMapper;

@Service
public class SendHisPayNoticeService {

	/** logger */
	private static final Logger logger = LoggerFactory.getLogger(SendHisPayNoticeService.class);

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
	public DepositPayNoticeResponse sendHisDepositPayNotice(JSONObject request) {
		JSONObject json = HisHttpJson.executeHisApi("ZYYJBJZF", request);
		DepositPayNoticeResponse respone = HisHttpJson.convJsonToBean(json, DepositPayNoticeResponse.class);
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
	public BaseResponse sendHisRegisterPayNotice(JSONObject request) {
		JSONObject json = HisHttpJson.executeHisApi("Pay_YYRegister", request);
		BaseResponse respone = HisHttpJson.convJsonToBean(json, BaseResponse.class);
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
	public BaseResponse sendHisClinicPayNotice(JSONObject request) {
		JSONObject json = HisHttpJson.executeHisApi("MZJFDDZF", request);
		BaseResponse respone = HisHttpJson.convJsonToBean(json, BaseResponse.class);
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
