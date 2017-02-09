package cn.com.liandisys.ahis.webapp.service;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.AppointmentOrderEntity;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg004Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.AppointmentResponse;
import cn.com.liandisys.ahis.webapp.mapper.Mfrg004Mapper;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import net.sf.json.JSONObject;

@Service
public class Mfrg004Service {
	@Autowired
	private UserInfoMapper userInfoMapper;
	@Autowired
	private Mfrg004Mapper mfrg004Mapper;

	public AppointmentOrderEntity appoint(Mfrg004Form mfrg004Form, LoginUserInfo loginUserInfo) {
		String psOrdNum = padZeroToLeft(String.valueOf(mfrg004Mapper.getOrderNo()), 8);
		UserInfoEntity userInfo = userInfoMapper.selectByPrimaryKey((long) loginUserInfo.getUserID());
		JSONObject json = new JSONObject();
		json.put("psOrdNum", psOrdNum);
		json.put("deptCode", mfrg004Form.getDeptCode());
		json.put("doctorCode", mfrg004Form.getDoctorCode());
		json.put("regFee", mfrg004Form.getRegFee());
		json.put("scheduleDate", mfrg004Form.getReserveDate());
		json.put("timeFlag", mfrg004Form.getTimeFlag());
		json.put("patType","1");
		json.put("patName",loginUserInfo.getName());
		json.put("patSex",userInfo.getSex());
		json.put("patAge",String.valueOf(getAge(userInfo.getBirthdate())));
		json.put("patMobile",loginUserInfo.getMobileNo());
		json.put("patIdType","1");
		json.put("patIdNo",loginUserInfo.getShenfenzhenghao());
		AppointmentOrderEntity entity = null;
		try {
			JSONObject responeJson = HisHttpJson.executeHisApi("appointment", json);
			AppointmentResponse respone=HisHttpJson.convJsonToBean(responeJson, AppointmentResponse.class);
			String resultCode = respone.getResultCode();
			if (resultCode.equals("0")) {
				entity = createAppointmentOrder(psOrdNum, respone, userInfo);
				mfrg004Mapper.insertAppointOrder(entity);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	private String padZeroToLeft(String value, int length) {
		int difference = length - value.length();
		if (difference <= 0) {
			return value;
		}
		StringBuffer padValue = new StringBuffer();
		for (int i = 0; i < difference; i++) {
			padValue.append("0");
		}
		padValue.append(value);
		return padValue.toString();
	}

	private AppointmentOrderEntity createAppointmentOrder(String psOrdNum, AppointmentResponse respone,
			UserInfoEntity userInfo) {
		AppointmentOrderEntity entity = new AppointmentOrderEntity();
		entity.setUserId(userInfo.getUserid());
		entity.setHisOrdNum(respone.getHisOrdNum());
		entity.setPsOrdNum(psOrdNum);
		entity.setStatus(1);
		entity.setPatCardType("1");
		entity.setPatCardNo(null != userInfo.getJzcardno() ? userInfo.getJzcardno() : "12345678901234567");
		entity.setInsertTimeStamp(new Timestamp(new Date().getTime()));
		return entity;
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
