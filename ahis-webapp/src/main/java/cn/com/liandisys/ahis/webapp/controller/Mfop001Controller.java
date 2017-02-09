package cn.com.liandisys.ahis.webapp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop001Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpClient;
import cn.com.liandisys.ahis.webapp.his.entity.request.PayRecordSereachRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.RegRecordSereachRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.PayRecordSereachItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.PayRecordSereachResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegRecordSereachItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegRecordSereachResponse;
import cn.com.liandisys.ahis.webapp.service.Mfop001Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Controller
@RequestMapping("/m/mfop001/*")
public class Mfop001Controller extends AbstractAhisController<Mfop001Form> {

	private String STATUS_1 = "1";
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	Mfop001Service mfop001Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param mfop001Form
	 */
	@RequestMapping("init")
	public String init(@ModelAttribute Mfop001Form mfop001Form, HttpServletRequest req, String isPaid) {

		// TODO 医保余额无取得接口
		mfop001Form.setBalance("500.00");

		List<RegRecordSereachItem> regRecordList = new ArrayList<>();

		mfop001Form.setHidPatCardNo("0001");
		mfop001Form.setHidPatCardType("1");
		try {
			regRecordList.addAll(regRecordSereach(0, mfop001Form.getHidPatCardNo(), mfop001Form.getHidPatCardType()));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		List<HospitalOrderEntity> hisOrderList = new ArrayList<>();

		for (RegRecordSereachItem regRecord : regRecordList) {
			HospitalOrderEntity hisOrder = new HospitalOrderEntity();
			if (STATUS_1.equals(regRecord.getStatus())) {
				hisOrder.setHisOrdNum(regRecord.getHisOrdNum());
				hisOrder.setPayName("挂号费");
				hisOrder.setScheduleDate(regRecord.getScheduleDate());
				if ("1".equals(regRecord.getTimeFlag())) {
					hisOrder.setTimeFlag("上午");
				} else if ("2".equals(regRecord.getTimeFlag())) {
					hisOrder.setTimeFlag("下午");
				} else if ("3".equals(regRecord.getTimeFlag())) {
					hisOrder.setTimeFlag("晚上");
				} else if ("4".equals(regRecord.getTimeFlag())) {
					hisOrder.setTimeFlag("全天");
				}

				hisOrder.setDeptName(regRecord.getDeptName());
				hisOrder.setDoctorName(regRecord.getDoctorName());
				hisOrder.setTotalAmt(regRecord.getRegFee());
				hisOrder.setMedInsAmt(0.00);
				hisOrder.setSelfAmt(regRecord.getRegFee());
				// TODO 挂号费的医保部分区分不了
				hisOrder.setTotalAmt_all(regRecord.getRegFee());
				hisOrder.setTotalAmt_paid(0.00);
				hisOrder.setTotalAmt_pay(regRecord.getRegFee());
				hisOrder.setMedIns_all(0.00);
				hisOrder.setMedIns_paid(0.00);
				hisOrder.setMedIns_pay(0.00);
				hisOrder.setSelfAmt_all(regRecord.getRegFee());
				hisOrder.setSelfAmt_paid(0.00);
				hisOrder.setSelfAmt_pay(regRecord.getRegFee());

				hisOrderList.add(hisOrder);
			}
		}

		// TODO 2.1.6.1. 门诊待缴费记录查询
		List<PayRecordSereachItem> payRecordSereachList = new ArrayList<>();
		try {
			payRecordSereachList.addAll(payRecordSereach("0001", "1"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		for (PayRecordSereachItem payRecordSereach : payRecordSereachList) {
			HospitalOrderEntity newHisOrder = new HospitalOrderEntity();
			newHisOrder.setHisOrdNum(payRecordSereach.getHisOrdNum());
			newHisOrder.setPayName(payRecordSereach.getPayName());
			newHisOrder.setDeptName(payRecordSereach.getDeptName());
			newHisOrder.setDoctorName(payRecordSereach.getDoctorName());
			newHisOrder.setTotalAmt(payRecordSereach.getTotalAmt());
			newHisOrder.setMedInsAmt(payRecordSereach.getMedInsAmt());
			newHisOrder.setSelfAmt(payRecordSereach.getSelfAmt());
			newHisOrder.setTotalAmt_all(payRecordSereach.getTotalAmt());
			newHisOrder.setTotalAmt_paid(0.00);
			newHisOrder.setTotalAmt_pay(payRecordSereach.getTotalAmt());
			newHisOrder.setMedIns_all(payRecordSereach.getMedInsAmt());
			newHisOrder.setMedIns_paid(0.00);
			newHisOrder.setMedIns_pay(payRecordSereach.getMedInsAmt());
			newHisOrder.setSelfAmt_all(payRecordSereach.getSelfAmt());
			newHisOrder.setSelfAmt_paid(0.00);
			newHisOrder.setSelfAmt_pay(payRecordSereach.getSelfAmt());

			hisOrderList.add(newHisOrder);
		}

		SessionService.setAttribute(AhisConstants.SESSION_KEY_MFOP001_LIST, hisOrderList);
		mfop001Form.setOrderList(hisOrderList);

		// 已支付一览取得
		LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();

		List<HospitalOrderEntity> hasPaidList = mfop001Service.getHasPaid(userInfo.getUserID());
		mfop001Form.setHasPaidList(hasPaidList);

		if (isPaid != null) {
			mfop001Form.setIsPaid(isPaid);
		} else {
			mfop001Form.setIsPaid("2");
		}
		return "MFOP001";
	}

	/**
	 * 2.1.3.6. 预约挂号记录查询处理。
	 * 
	 * @param mfop001Form
	 */
	public List<RegRecordSereachItem> regRecordSereach(int hisOrdNum, String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		RegRecordSereachRequest requestEntity = new RegRecordSereachRequest();
		requestEntity.setHisOrdNum(hisOrdNum);
		requestEntity.setPatCardNo(patCardNo);
		requestEntity.setPatCardType(patCardType);
		RegRecordSereachResponse respone = HisHttpClient.executeHisApi("/his/regRecordSereach", requestEntity,
				RegRecordSereachRequest.class, RegRecordSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<RegRecordSereachItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}

	/**
	 * 2.1.6.1. 门诊待缴费记录查询处理。
	 * 
	 * @param mfop001Form
	 */
	public List<PayRecordSereachItem> payRecordSereach(String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		PayRecordSereachRequest requestEntity = new PayRecordSereachRequest();
		requestEntity.setPatCardNo(patCardNo);
		requestEntity.setPatCardType(patCardType);
		PayRecordSereachResponse respone = HisHttpClient.executeHisApi("/his/payRecordSereach", requestEntity,
				PayRecordSereachRequest.class, PayRecordSereachResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<PayRecordSereachItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}

	/**
	 * 缴费处理。
	 * 
	 * @param mfop001Form
	 */
	@RequestMapping("doPay")
	public String doPay(@ModelAttribute Mfop001Form mfop001Form) {

		List<HospitalOrderEntity> hisOrdInfoList = SessionService.getAttribute(AhisConstants.SESSION_KEY_MFOP001_LIST);
		for (HospitalOrderEntity hisOrd : hisOrdInfoList) {
			if (mfop001Form.getHidHisOrdNum().equals(String.valueOf(hisOrd.getHisOrdNum()))) {
				SessionService.setAttribute(AhisConstants.SESSION_KEY_MFOP001, hisOrd);
			}
		}

		return "redirect:/m/mfop002/index";
	}

	/**
	 * 缴费详细迁移。
	 * 
	 * @param mfop001Form
	 */
	@RequestMapping(value = "goDetail")
	public String goDetail(@ModelAttribute Mfop001Form mfop001Form, HttpServletRequest req) {

		String hisOrdNum = mfop001Form.getHidHisOrdNum();
		String patCardNo = mfop001Form.getHidPatCardNo();
		String patCardType = mfop001Form.getHidPatCardType();

		return "redirect:/m/mfop004/init?hisOrdNum=" + hisOrdNum + "&patCardNo=" + patCardNo + "&patCardType="
				+ patCardType;
	}
}
