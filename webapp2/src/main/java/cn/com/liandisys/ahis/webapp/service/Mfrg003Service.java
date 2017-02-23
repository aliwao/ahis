package cn.com.liandisys.ahis.webapp.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DoctorBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.RegisterBaseHisResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.DoctorBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.RegisterBaseItem;


@Service
@Transactional
public class Mfrg003Service {
	private static final Logger logger = LoggerFactory.getLogger(Mfrg003Service.class);

	@RequestMapping
	public List<DoctorBaseItem> getDoctorDetailList(JSONObject requestJosn) {
		JSONObject responeJson = HisHttpJson.executeHisApi("doctor-info", requestJosn);
//		DoctorBaseHisResponse respone=HisHttpJson.convJsonToBean(responeJson, DoctorBaseHisResponse.class);
//		logger.debug(respone.getResultCode());
//		logger.debug(respone.getResultMessage());
//
//		if (respone.getItemList() != null) {
//			respone.getItemList().forEach(item -> {
//				logger.trace(item.getDoctorCode());
//				logger.trace(item.getDoctorName());
//			});
//			return respone.getItemList();
//		}
		return new ArrayList<>();
	}

	@RequestMapping
	public List<RegisterBaseItem> getNumberSourceList(JSONObject requestJosn) {
		
		Date now = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = format.format(DateUtils.addDays(now, 1));
		String endDate = format.format(DateUtils.addDays(now, 10));
		requestJosn.put("beginDate", beginDate);
		requestJosn.put("endDate", endDate);
		JSONObject responeJson  = HisHttpJson.executeHisApi("register-info", requestJosn);
//		RegisterBaseHisResponse respone=HisHttpJson.convJsonToBean(responeJson, RegisterBaseHisResponse.class);
//		logger.debug(respone.getResultCode());
//		logger.debug(respone.getResultMessage());
//		if (respone.getItemList() != null) {
//			respone.getItemList().forEach(item -> {
//				logger.trace(item.getDeptCode());
//				logger.trace(item.getDoctorCode());
//			});
//			return  respone.getItemList();
//		}
		return new ArrayList<>();
	}
}
