package cn.com.liandisys.ahis.webapp.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.dto.PersonPaymentInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.RegisterHistoryEntity;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg004Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.AppointmentResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.CreatPatientInfoResponse;
import cn.com.liandisys.ahis.webapp.mapper.PersonPaymentInfoMapper;
import cn.com.liandisys.ahis.webapp.mapper.RegisterHistoryMapper;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.utils.MakeOrdNumUtil;


@Service
public class Mfrg004Service {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private PersonPaymentInfoMapper personPaymentInfoMapper;
	@Autowired
	private RegisterHistoryMapper registerHistoryMapper;

	public RegisterHistoryEntity appoint(Mfrg004Form mfrg004Form, LoginUserInfo loginUserInfo) {
		String psOrdNum = MakeOrdNumUtil.create();
		UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey((long) loginUserInfo.getUserID());
		PersonPaymentInfoEntity personPaymentInfoEntity = personPaymentInfoMapper
				.getDiagnosisCardNoByUserID(loginUserInfo.getUserID());
		String patCardNo = null;
		if (null == personPaymentInfoEntity || isNullOrEmpty(personPaymentInfoEntity.getDiagnosisCardNo())) {
			CreatPatientInfoResponse patientInfoResponse = getPatientInfoResponse(loginUserInfo, userInfo);
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
		AppointmentResponse respone = getAppointmentResponse(psOrdNum, mfrg004Form, loginUserInfo, userInfo);
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

	private CreatPatientInfoResponse getPatientInfoResponse(LoginUserInfo loginUserInfo, UserInfoEntity userInfo) {
		CreatPatientInfoResponse respone = null;
		JSONObject json = new JSONObject();
		json.put("patName", userInfo.getFullName());
		json.put("patSex", userInfo.getSex());
		json.put("patAge", String.valueOf(getAge(userInfo.getBirthDate())));
		json.put("patBirth", userInfo.getBirthDate());
		json.put("patAddress", userInfo.getAddress());
		json.put("patMobile", loginUserInfo.getMobileNo());
		json.put("patIdType", "1");
		json.put("patIdNo", userInfo.getIdentityCardNo());
		json.put("guardName", userInfo.getFullName());
		json.put("guardIdType", "1");
		json.put("guardIdNo", userInfo.getIdentityCardNo());

			JSONObject responeJson = HisHttpJson.executeHisApi("CreatPatientInfo", json);
			respone = HisHttpJson.convJsonToBean(responeJson, CreatPatientInfoResponse.class);

		return respone;
	}

	private AppointmentResponse getAppointmentResponse(String psOrdNum, Mfrg004Form mfrg004Form,
			LoginUserInfo loginUserInfo, UserInfoEntity userInfo) {
		AppointmentResponse respone = null;
		JSONObject json = new JSONObject();
		json.put("psOrdNum", psOrdNum);
		json.put("deptCode", mfrg004Form.getDeptCode());
		json.put("doctorCode", mfrg004Form.getDoctorCode());
		json.put("regFee", mfrg004Form.getRegFee());
		json.put("scheduleDate", mfrg004Form.getReserveDate());
		json.put("timeFlag", mfrg004Form.getTimeFlag());
		json.put("patType", "1");
		json.put("patName", loginUserInfo.getFullName());
		json.put("patSex", userInfo.getSex());
		json.put("patAge", String.valueOf(getAge(userInfo.getBirthDate())));
		json.put("patMobile", loginUserInfo.getMobileNo());
		json.put("patIdType", "1");
		json.put("patIdNo", loginUserInfo.getIdentityCardNo());

			JSONObject responeJson = HisHttpJson.executeHisApi("Lock_YYRegister", json);
			respone = HisHttpJson.convJsonToBean(responeJson, AppointmentResponse.class);

		return respone;
	}

	private boolean isNullOrEmpty(String value) {
		return null == value || value.isEmpty();
	}

	private RegisterHistoryEntity createRegisterInfo(String psOrdNum, String patCardNo, Mfrg004Form mfrg004Form,
			AppointmentResponse response, UserInfoEntity userInfo) {
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
