package cn.com.liandisys.ahis.webapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.dto.PersonPaymentInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.RegisterHistoryEntity;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg004Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointmentBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.CreatPatientInfoBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointmentBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.CreatPatientInfoBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.factory.AppointmentHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.factory.CreatPatientInfoHisExecuteLogicFactory;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractAppointmentHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractCreatPatientInfoHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.mapper.PersonPaymentInfoMapper;
import cn.com.liandisys.ahis.webapp.mapper.RegisterHistoryMapper;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.utils.MakeOrdNumUtil;
import cn.com.liandisys.common.util.DateFormatUtil;

@Service
public class Mfrg004Service {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private PersonPaymentInfoMapper personPaymentInfoMapper;
	@Autowired
	private RegisterHistoryMapper registerHistoryMapper;
	@Autowired
	private CreatPatientInfoHisExecuteLogicFactory creatPatientInfoFactory;
	@Autowired
	AppointmentHisExecuteLogicFactory appointmentFactory;

	public RegisterHistoryEntity appoint(Mfrg004Form mfrg004Form, LoginUserInfo loginUserInfo) {
		String psOrdNum = MakeOrdNumUtil.create();
		UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey((long) loginUserInfo.getUserID());
		PersonPaymentInfoEntity personPaymentInfoEntity = personPaymentInfoMapper
				.getDiagnosisCardNoByUserID(loginUserInfo.getUserID());
		String patCardNo = null;
		if (null == personPaymentInfoEntity || isNullOrEmpty(personPaymentInfoEntity.getDiagnosisCardNo())) {
			CreatPatientInfoBaseHisResponse patientInfoResponse = getPatientInfoResponse(loginUserInfo, userInfo);
			if (patientInfoResponse.getResultCode().equals("0")) {
				patCardNo = patientInfoResponse.getPatCardNo();
				if (null == personPaymentInfoEntity) {
					personPaymentInfoEntity = new PersonPaymentInfoEntity();
					personPaymentInfoEntity.setUserID(userInfo.getUserID());
					personPaymentInfoEntity.setDiagnosisCardNo(patCardNo);
					personPaymentInfoEntity.setLoginUser(userInfo.getFullName());
					personPaymentInfoEntity.setUpdateUser(userInfo.getFullName());
					personPaymentInfoMapper.insertNewRecord(personPaymentInfoEntity);
				} else {
					personPaymentInfoMapper.updateDiagnosisCardNoByUserID(loginUserInfo.getUserID(), patCardNo);
				}
			}
		} else {
			patCardNo = personPaymentInfoEntity.getDiagnosisCardNo();
		}
		RegisterHistoryEntity entity = null;
		AppointmentBaseHisResponse respone = getAppointmentResponse(psOrdNum, mfrg004Form, loginUserInfo, userInfo);
		String resultCode = respone.getResultCode();
		if (resultCode.equals("0")) {
			entity = createRegisterInfo(psOrdNum, patCardNo, mfrg004Form, respone, userInfo);
			registerHistoryMapper.insertRegisterHistory(entity);
		}
		return entity;
	}

	public boolean isInfoComplete(LoginUserInfo loginUserInfo) {
		UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey((long) loginUserInfo.getUserID());
		String sex = userInfo.getSex();
		Date birthdate = userInfo.getBirthDate();
		return !isNullOrEmpty(sex) && null != birthdate;
	}

	private CreatPatientInfoBaseHisResponse getPatientInfoResponse(LoginUserInfo loginUserInfo,
			UserInfoEntity userInfo) {
		CreatPatientInfoBaseHisRequest req = new CreatPatientInfoBaseHisRequest();
		req.setPatName(userInfo.getFullName());
		req.setPatSex(userInfo.getSex());
		req.setPatAge(String.valueOf(getAge(userInfo.getBirthDate())));
		req.setPatBirth(DateFormatUtil.formatDateToBarYmd(userInfo.getBirthDate()));
		req.setPatAddress(userInfo.getAddress());
		req.setPatMobile(loginUserInfo.getMobileNo());
		req.setPatIdType("1");
		req.setPatIdNo(userInfo.getIdentityCardNo());
		req.setGuardName(userInfo.getFullName());
		req.setGuardIdType("1");
		req.setGuardIdNo(userInfo.getIdentityCardNo());
		AbstractCreatPatientInfoHisExecuteLogic logic = creatPatientInfoFactory.getLogic();
		CreatPatientInfoBaseHisResponse res = logic.execute(req);
		return res;
	}

	private AppointmentBaseHisResponse getAppointmentResponse(String psOrdNum, Mfrg004Form mfrg004Form,
			LoginUserInfo loginUserInfo, UserInfoEntity userInfo) {
		AbstractAppointmentHisExecuteLogic logic = appointmentFactory.getLogic();
		AppointmentBaseHisRequest req = new AppointmentBaseHisRequest();
		req.setPsOrdNum(psOrdNum);
		req.setDeptCode(mfrg004Form.getDeptCode());
		req.setDoctorCode(mfrg004Form.getDoctorCode());
		req.setRegFee(mfrg004Form.getRegFee());
		req.setScheduleDate(mfrg004Form.getReserveDate());
		req.setTimeFlag(mfrg004Form.getTimeFlag());
		req.setPatType("1");
		req.setPatName(loginUserInfo.getFullName());
		req.setPatSex(userInfo.getSex());
		req.setPatAge(String.valueOf(getAge(userInfo.getBirthDate())));
		req.setPatMobile(loginUserInfo.getMobileNo());
		req.setPatIdType("1");
		req.setPatIdNo(loginUserInfo.getIdentityCardNo());
		AppointmentBaseHisResponse res = logic.execute(req);
		return res;
	}

	private boolean isNullOrEmpty(String value) {
		return null == value || value.isEmpty();
	}

	private RegisterHistoryEntity createRegisterInfo(String psOrdNum, String patCardNo, Mfrg004Form mfrg004Form,
			AppointmentBaseHisResponse response, UserInfoEntity userInfo) {
		RegisterHistoryEntity entity = new RegisterHistoryEntity();
		entity.setRegisterNo(psOrdNum);
		entity.setUserID(userInfo.getUserID());
		entity.setHospitalCode("0001");
		entity.setDepartmentCode(mfrg004Form.getDeptCode());
		entity.setDoctorCode(mfrg004Form.getDoctorCode());
		entity.setRegisterDate(new Date());
		entity.setHappenDate(getDate(mfrg004Form.getReserveDate()));
		entity.setHappenPeriod("1");
		entity.setRegisterFee(Double.valueOf(mfrg004Form.getRegFee()));
		entity.setStopFlag("0");
		entity.setHisOrdNum(response.getHisOrdNum());
		entity.setRegisterStatus("0");
		entity.setSerialNum(response.getSerialNum());
		entity.setVisitPosition(response.getVisitPosition());
		entity.setLoginUser(userInfo.getFullName());
		entity.setUpdateUser(userInfo.getFullName());
		return entity;
	}

	private Date getDate(String value) {
		int year = Integer.valueOf(value.substring(0, value.indexOf("年")));
		int month = Integer.valueOf(value.substring(value.indexOf("年") + 1, value.indexOf("月"))) - 1;
		int date = Integer.valueOf(value.substring(value.indexOf("月") + 1, value.indexOf("日")));
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date);
		return calendar.getTime();
	}

	private int getAge(Date birthDay) {

		Calendar calBegin = Calendar.getInstance(); // 获取日历实例
		Calendar calEnd = Calendar.getInstance();
		calBegin.setTime(stringTodate(birthDay, "yyyy")); // 字符串按照指定格式转化为日期
		calEnd.setTime(stringTodate(new Date(), "yyyy"));
		return calEnd.get(Calendar.YEAR) - calBegin.get(Calendar.YEAR);

	}

	private Date stringTodate(Date dateStr, String formatStr) {
		// 如果时间为空则默认当前时间
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(formatStr);

		String time = "";

		time = format.format(dateStr);
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
