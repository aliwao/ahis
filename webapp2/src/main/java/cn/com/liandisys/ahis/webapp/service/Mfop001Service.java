package cn.com.liandisys.ahis.webapp.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;
import cn.com.liandisys.ahis.webapp.entity.RegisterHistoryEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop001Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PaymentRecordBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.RegisterRecordBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PaymentRecordBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.RegisterRecordBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.PaymentRecordBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.RegisterRecordBaseItem;
import cn.com.liandisys.ahis.webapp.his.factory.PaymentRecordHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.RegisterRecordHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPaymentRecordHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractRegisterRecordHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.mapper.Mfop001Mapper;
import cn.com.liandisys.ahis.webapp.mapper.PaymentRecordMapper;
import cn.com.liandisys.ahis.webapp.mapper.RegisterHistoryMapper;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;
import cn.com.liandisys.ahis.webapp.utils.MakeOrdNumUtil;

@Service
@Transactional
public class Mfop001Service {

	@Autowired
	private Mfop001Mapper mfop001Mapper;
	@Autowired
	private RegisterHistoryMapper registerHistoryMapper;
	@Autowired
	private PaymentRecordMapper paymentRecordMapper;
	@Autowired
	private RegisterRecordHisExecuteLogicFactory registerRecordHisExecuteLogicFactory;
	@Autowired
	private PaymentRecordHisExecuteLogicFactory paymentRecordHisExecuteLogicFactory;

	@Value("${payment.sltf.mock.confirm.url}")
	private String confirmMockUrl;

	private String STATUS_1 = "1";
	private static final Logger logger = LoggerFactory.getLogger(Mfop001Service.class);

	/**
	 * 已支付一览画面表示data取得。
	 * 
	 * @param mfop001Form
	 * @return Mfop001Form
	 */
	public Mfop001Form init(Mfop001Form mfop001Form) {

		List<RegisterRecordBaseItem> regRecordList = new ArrayList<>();

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

		for (RegisterRecordBaseItem regRecord : regRecordList) {
			HospitalOrderEntity hisOrder = new HospitalOrderEntity();
			if (STATUS_1.equals(regRecord.getStatus())) {
				hisOrder.setHisOrdNum(regRecord.getHisOrdNum());
				hisOrder.setPayName("挂号费");
				hisOrder.setScheduleDate(regRecord.getScheduleDate());
				hisOrder.setTimeFlag(regRecord.getTimeFlag());
				hisOrder.setDeptCode(regRecord.getDeptCode());
				hisOrder.setDeptName(regRecord.getDeptName());
				hisOrder.setDoctorCode(regRecord.getDoctorCode());
				hisOrder.setDoctorName(regRecord.getDoctorName());
				hisOrder.setTotalAmt(regRecord.getRegFee());
				hisOrder.setMedInsAmt(0.00);
				hisOrder.setSelfAmt(0.00);

				hisOrderList.add(hisOrder);
			}
		}

		// 2.1.6.1. 门诊待缴费记录查询
		List<PaymentRecordBaseItem> payRecordSereachList = new ArrayList<>();
		try {
			payRecordSereachList.addAll(payRecordSereach("0001", "1"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		for (PaymentRecordBaseItem payRecordSereach : payRecordSereachList) {
			HospitalOrderEntity newHisOrder = new HospitalOrderEntity();
			newHisOrder.setHisOrdNum(payRecordSereach.getHisOrdNum());
			newHisOrder.setPayName(payRecordSereach.getPayName());
			newHisOrder.setDeptName(payRecordSereach.getDeptName());
			newHisOrder.setDoctorName(payRecordSereach.getDoctorName());
			newHisOrder.setTotalAmt(payRecordSereach.getTotalAmt());
			newHisOrder.setMedInsAmt(payRecordSereach.getMedInsAmt());
			newHisOrder.setSelfAmt(payRecordSereach.getSelfAmt());

			hisOrderList.add(newHisOrder);
		}

		SessionService.setAttribute(AhisConstants.SESSION_KEY_MFOP001_LIST, hisOrderList);
		mfop001Form.setOrderList(hisOrderList);

		// 已支付一览取得
		List<HospitalOrderEntity> paidHisOrderList = new ArrayList<>();
		LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();

		List<PaymentRecordDto> hasPaidList = getHasPaid(userInfo.getUserID());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月dd日");
		if (!hasPaidList.isEmpty()) {
			mfop001Form.setPayTime(sdf.format(hasPaidList.get(0).getPaidDate()));
		}else {
			mfop001Form.setPayTime(sdf.format(new Date()));
		}

		for (PaymentRecordDto dto : hasPaidList) {
			HospitalOrderEntity entity = new HospitalOrderEntity();
			entity.setPayName(dto.getPaymentName());
			entity.setDeptName(dto.getDepartmentName());
			entity.setDoctorName(dto.getDoctorName());
			entity.setPayTime(sdf.format(dto.getPaidDate()));
			entity.setTotalAmt(dto.getOrderFee());
			entity.setMedInsAmt(dto.getMedicalInsuranceAmount());
			entity.setSelfAmt(dto.getMedicalselfAmount());

			paidHisOrderList.add(entity);
		}
		mfop001Form.setHasPaidList(paidHisOrderList);

		return mfop001Form;
	}

	/**
	 * 2.1.3.6. 预约挂号记录查询处理。
	 * 
	 * @param mfop001Form
	 */
	public List<RegisterRecordBaseItem> regRecordSereach(int hisOrdNum, String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		JSONObject requestJson = new JSONObject();
		requestJson.put("hisOrdNum", hisOrdNum);
		requestJson.put("patCardNo", patCardNo);
		requestJson.put("patCardType", patCardType);
		
		AbstractRegisterRecordHisExecuteLogic logic = registerRecordHisExecuteLogicFactory.getLogic();
		RegisterRecordBaseHisRequest request = new RegisterRecordBaseHisRequest();
		request.setHisOrdNum(hisOrdNum);
		request.setPatCardNo(patCardNo);
		request.setPatCardType(patCardType);
		RegisterRecordBaseHisResponse respone = logic.execute(request);
		
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<RegisterRecordBaseItem> result = new ArrayList<>();
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
	public List<PaymentRecordBaseItem> payRecordSereach(String patCardNo, String patCardType)
			throws UnsupportedEncodingException, JAXBException {

		AbstractPaymentRecordHisExecuteLogic logic = paymentRecordHisExecuteLogicFactory.getLogic();
		PaymentRecordBaseHisRequest request = new PaymentRecordBaseHisRequest();
		request.setPatCardNo(patCardNo);
		request.setPatCardType(patCardType);
		PaymentRecordBaseHisResponse respone = logic.execute(request);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		List<PaymentRecordBaseItem> result = new ArrayList<>();
		respone.getItemList().forEach(item -> {
			result.add(item);
		});
		return result;
	}

	/**
	 * 支付前操作。
	 * 
	 * @param mfop001Form
	 * @return List<HospitalOrderEntity>
	 * @throws ParseException
	 */
	public RedirectView doPay(Mfop001Form mfop001Form) throws ParseException {

		String hisOrdNum = mfop001Form.getHidHisOrdNum();
		LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();

		List<HospitalOrderEntity> hisOrdInfoList = SessionService.getAttribute(AhisConstants.SESSION_KEY_MFOP001_LIST);
		HospitalOrderEntity hisOrdEntity = new HospitalOrderEntity();
		for (HospitalOrderEntity hisOrd : hisOrdInfoList) {
			if (mfop001Form.getHidHisOrdNum().equals(String.valueOf(hisOrd.getHisOrdNum()))) {
				hisOrdEntity = hisOrd;
			}
		}

		if ("挂号费".equals(hisOrdEntity.getPayName())) {
			int record = getRegisterHistory(hisOrdNum);
			if (record == 0) {
				String psOrdNum = MakeOrdNumUtil.create();
				RegisterHistoryEntity insertEntity = new RegisterHistoryEntity();

				insertEntity.setRegisterNo(psOrdNum);
				insertEntity.setUserID(userInfo.getUserID());
				insertEntity.setHospitalCode("0001");
				insertEntity.setDepartmentCode(hisOrdEntity.getDeptCode());
				insertEntity.setDoctorCode(hisOrdEntity.getDoctorCode());

				String strDate = hisOrdEntity.getScheduleDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(strDate);
				insertEntity.setRegisterDate(date);
				insertEntity.setHappenDate(date);
				insertEntity.setHappenPeriod(hisOrdEntity.getTimeFlag());

				BigDecimal amt = new BigDecimal(hisOrdEntity.getTotalAmt());
				amt.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				insertEntity.setRegisterFee(amt.doubleValue());
				insertEntity.setStopFlag("0");
				insertEntity.setHisOrdNum(hisOrdNum);
				insertEntity.setRegisterStatus("0");
				insertEntity.setSerialNum("123456789");
				insertEntity.setVisitPosition("门诊 3号楼");
				insertEntity.setLoginTime(Timestamp.valueOf(LocalDateTime.now()));
				insertEntity.setLoginUser(String.valueOf(userInfo.getUserID()));
				insertEntity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
				insertEntity.setUpdateUser(String.valueOf(userInfo.getUserID()));
				insertRegisterHistory(insertEntity);
			}
		}
		int paymentRecord = getPaymentRecord(hisOrdNum);
		String psOrdNum_1 = MakeOrdNumUtil.create(3);
		if (paymentRecord == 0) {

			PaymentRecordDto dto = new PaymentRecordDto();
			dto.setPaymentNo(psOrdNum_1);
			if ("挂号费".equals(hisOrdEntity.getPayName())) {
				dto.setPaymentRefType("1");
			} else {
				dto.setPaymentRefType("3");
			}
			dto.setHisOrdNum(Integer.valueOf(hisOrdNum));
			dto.setUserId(userInfo.getUserID());
			dto.setDepartmentName(hisOrdEntity.getDeptName());
			dto.setDoctorName(hisOrdEntity.getDoctorName());
			dto.setPaymentName(hisOrdEntity.getPayName());
			dto.setOrderFee(hisOrdEntity.getTotalAmt());
			dto.setMedicalInsuranceAmount(hisOrdEntity.getMedInsAmt());
			dto.setMedicalselfAmount(hisOrdEntity.getSelfAmt());
			dto.setPaidState("0");
			dto.setOrderType("1");
			dto.setPaymentNotice("0");
			dto.setLoginTime(Timestamp.valueOf(LocalDateTime.now()));
			dto.setLoginUser(String.valueOf(userInfo.getUserID()));
			dto.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
			dto.setUpdateUser(String.valueOf(userInfo.getUserID()));

			insertPaymentRecord(dto);
		}

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(confirmMockUrl);
		Map<String, String> att = new HashMap<>();
		att.put("paymentNo", psOrdNum_1);
		redirectView.setAttributesMap(att);
		return redirectView;
		/*
		 * ModelAndView mav = new ModelAndView("redirect:" + confirmMockUrl);
		 * mav.addObject("orderid", hisOrdNum);
		 * 
		 * return mav;
		 */

	}

	/**
	 * 支付后操作。
	 * 
	 * @param mfop001Form
	 * @return List<HospitalOrderEntity>
	 * @throws ParseException
	 */
	public void paymentCompleted(Mfop001Form mfop001Form) throws ParseException {

	}

	/**
	 * 已支付一览画面表示data取得。
	 * 
	 * @param userId
	 * @return List<PaymentRecordDto>
	 */
	public List<PaymentRecordDto> getHasPaid(int userId) {

		return mfop001Mapper.getHasPaid(userId);
	}

	/**
	 * 挂号履历查询。
	 * 
	 * @param userId
	 * @return count
	 */
	private int getRegisterHistory(String hisOrdNum) {

		return mfop001Mapper.getRegisterHistory(hisOrdNum);
	}

	/**
	 * 个人缴费记录查询。
	 * 
	 * @param userId
	 * @return count
	 */
	private int getPaymentRecord(String hisOrdNum) {

		return mfop001Mapper.getPaymentRecord(hisOrdNum);
	}

	/**
	 * 挂号履历作成。
	 * 
	 * @param card
	 *            缴费信息
	 * @return 插入DB件数
	 */
	private void insertRegisterHistory(RegisterHistoryEntity entity) {
		registerHistoryMapper.insertRegisterHistory(entity);
	}

	/**
	 * 个人缴费记录登录。
	 * 
	 * @param userId
	 */
	private void insertPaymentRecord(PaymentRecordDto dto) {

		paymentRecordMapper.insertPaymentRecord(dto);
	}

}
