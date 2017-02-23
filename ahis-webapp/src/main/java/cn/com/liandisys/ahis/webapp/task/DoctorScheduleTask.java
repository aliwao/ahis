package cn.com.liandisys.ahis.webapp.task;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoItem;
import cn.com.liandisys.ahis.webapp.service.Mfrg002Service;

@Component
@Transactional
public class DoctorScheduleTask {

	@Autowired
	private Mfrg002Service mfrg002Service;

	private static final Logger logger = LoggerFactory.getLogger(DoctorScheduleTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 每天凌晨02:15 同步医生信息。
	 */
	@Scheduled(cron = "0 15 02 * * ?")
	public void syncDoctor() {
		logger.info("定时同步医生信息  >>>>>> The time is " + dateFormat.format(new Date()));
		syncDoctorInfoList();
	}

	/**
	 * 同步各家医院的科室信息，存入DB。
	 */
	private void syncDoctorInfoList() {
		// 清空医生表
		mfrg002Service.delAllDoctor();

		JSONObject json = new JSONObject();
		List<DoctorInfoItem> wx3yDoctorlist = new ArrayList<>();
		try {
			// mock 获取无锡三院的所有医生信息，假设医院代码为0001
			wx3yDoctorlist = mfrg002Service.getDoctorInfoList(json);
			wx3yDoctorlist.forEach(item -> {
				item.setHospitalCode("0001");
				mfrg002Service.insertDoctor(item);
			});

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
