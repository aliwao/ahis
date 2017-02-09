package cn.com.liandisys.ahis.webapp.service;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.controller.HelloController;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoResponse;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegisterInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.RegisterInfoResponse;
import net.sf.json.JSONObject;

@Service
@Transactional
public class Mfrg003Service {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping
	public List<DoctorInfoItem> getDoctorDetailList(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {
		JSONObject responeJson = HisHttpJson.executeHisApi("doctor-info", requestJosn);
		DoctorInfoResponse respone=HisHttpJson.convJsonToBean(responeJson, DoctorInfoResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());

		if (respone.getItemList() != null) {
			respone.getItemList().forEach(item -> {
				logger.trace(item.getDoctorCode());
				logger.trace(item.getDoctorName());
			});
			return respone.getItemList();
		}
		return new ArrayList<>();
	}

	@RequestMapping
	public List<RegisterInfoItem> getNumberSourceList(JSONObject requestJosn)
			throws UnsupportedEncodingException, JAXBException {
		
		Date now = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = format.format(DateUtils.addDays(now, 1));
		String endDate = format.format(DateUtils.addDays(now, 10));
		requestJosn.put("beginDate", beginDate);
		requestJosn.put("endDate", endDate);
		JSONObject responeJson  = HisHttpJson.executeHisApi("register-info", requestJosn);
		RegisterInfoResponse respone=HisHttpJson.convJsonToBean(responeJson, RegisterInfoResponse.class);
		logger.debug(respone.getResultCode());
		logger.debug(respone.getResultMessage());
		if (respone.getItemList() != null) {
			respone.getItemList().forEach(item -> {
				logger.trace(item.getDeptCode());
				logger.trace(item.getDoctorCode());
			});
			return  respone.getItemList();
		}
		return new ArrayList<>();
	}
}
