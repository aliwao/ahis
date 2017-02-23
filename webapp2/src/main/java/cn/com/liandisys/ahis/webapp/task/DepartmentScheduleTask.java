package cn.com.liandisys.ahis.webapp.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.DeptBaseItem;
import cn.com.liandisys.ahis.webapp.service.Mfrg001Service;

@Component
public class DepartmentScheduleTask {

	@Autowired
	private Mfrg001Service mfrg001Service;

	private static final Logger logger = LoggerFactory.getLogger(DepartmentScheduleTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 每天凌晨02:00 同步科室信息。
	 */
	@Scheduled(cron = "0 0 02 * * ?")
	public void syncDept() {
		logger.info("定时同步科室信息  >>>>>> The time is " + dateFormat.format(new Date()));
		syncDeptInfoList();
	}

	/**
	 * 同步各家医院的科室信息，存入DB。
	 */
	private void syncDeptInfoList() {
		// 清空科室表
		mfrg001Service.delAllDept();

		List<DeptBaseItem> wx3ydeptItemlist = new ArrayList<>();

		// mock 获取无锡三院的科室信息，假设医院代码为0001
		wx3ydeptItemlist = mfrg001Service.getWx3yDeptItemList();
		wx3ydeptItemlist.forEach(item -> {
			item.setHospitalCode("0001");
			mfrg001Service.insertDept(item);
		});
	}
}
