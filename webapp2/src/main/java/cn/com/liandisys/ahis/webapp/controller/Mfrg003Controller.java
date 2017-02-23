package cn.com.liandisys.ahis.webapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.NumberSourceEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg003Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.DoctorBaseItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.RegisterBaseItem;
import cn.com.liandisys.ahis.webapp.service.Mfrg003Service;


@Controller
@RequestMapping("/m/mfrg003/*")
public class Mfrg003Controller extends AbstractAhisController<Mfrg003Form> {
	@Autowired
	private Mfrg003Service mfrg003Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfrg003Form mfrg003Form, HttpServletRequest req) {
		List<DoctorBaseItem> doctorInfoItemList = new ArrayList<>();
		List<RegisterBaseItem> registerInfoItemList = new ArrayList<>();
		List<NumberSourceEntity> entities = new ArrayList<>();
		JSONObject doctorInfoRequestJson = new JSONObject();
		doctorInfoRequestJson.put("deptCode", mfrg003Form.getDeptCode());
		doctorInfoRequestJson.put("doctorCode",mfrg003Form.getDoctorCode());
		JSONObject registerInfoRequestJson = new JSONObject();
		registerInfoRequestJson.put("deptCode", mfrg003Form.getDeptCode());
		registerInfoRequestJson.put("doctorCode",mfrg003Form.getDoctorCode());

			/*doctorInfoItemList = mfrg003Service.getDoctorDetailList(doctorInfoRequestJson);
			DoctorBaseItem doctorInfo = doctorInfoItemList.get(0);
			mfrg003Form.setDeptName(doctorInfo.getDeptName());
			mfrg003Form.setDoctorName(doctorInfo.getDoctorName());
			mfrg003Form.setDoctorIntrodution(doctorInfo.getDoctorIntrodution());
			mfrg003Form.setDoctorSkill(Arrays.asList(doctorInfo.getDoctorSkill().split(",")));
			mfrg003Form.setDoctorTitle(doctorInfo.getDoctorTitle());
			mfrg003Form.setImgPath("/images/doctor/default.jpg");
			registerInfoItemList = mfrg003Service.getNumberSourceList(registerInfoRequestJson);*/
			registerInfoItemList.forEach(item -> {
				NumberSourceEntity entity = new NumberSourceEntity();
				entity.setScheduleDate(formatDate(item.getScheduleDate()));
				entity.setTimeFlag(item.getTimeFlag());
				entity.setLeftNum(item.getLeftNum());
				entity.setWeek(getWeekByDateStr(item.getScheduleDate()));
				entity.setRegFee(formatRegFee(item.getRegFee()));
				entities.add(entity);
			});
			mfrg003Form.setEntityList(entities);

		return forwardIndex();
	}

	private String formatRegFee(String regFee) {
		String before = regFee.substring(0, regFee.length() - 2);
		String after = regFee.substring(regFee.length() - 2);
		return before + "." + after;
	}

	private String formatDate(String date) {
		String[] dateArr = date.split("-");
		return dateArr[0] + "年" + dateArr[1] + "月" + dateArr[2] + "日";
	}

	private String getWeekByDateStr(String strDate) {
		int year = Integer.parseInt(strDate.substring(0, 4));
		int month = Integer.parseInt(strDate.substring(5, 7));
		int day = Integer.parseInt(strDate.substring(8, 10));

		Calendar c = Calendar.getInstance();

		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);

		String week = "";
		int weekIndex = c.get(Calendar.DAY_OF_WEEK);

		switch (weekIndex) {
		case 1:
			week = "星期日";
			break;
		case 2:
			week = "星期一";
			break;
		case 3:
			week = "星期二";
			break;
		case 4:
			week = "星期三";
			break;
		case 5:
			week = "星期四";
			break;
		case 6:
			week = "星期五";
			break;
		case 7:
			week = "星期六";
			break;
		}
		return week;
	}
}
