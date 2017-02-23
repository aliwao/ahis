package cn.com.liandisys.ahis.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.PatientsHospitalizedInfo;
import cn.com.liandisys.ahis.webapp.entity.PatientsHospitalizedEntity;
import cn.com.liandisys.ahis.webapp.form.Mfih004Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptItem;
import cn.com.liandisys.ahis.webapp.service.Mfih004Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;


/**
 * 住院履历页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfih004/*")
public class Mfih004Controller extends AbstractAhisController<Mfih004Form> {
	
	@Autowired
	private Mfih004Service mfih004Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfih004Form mfih004Form, HttpServletRequest req) {

		if (mfih004Form.getSearchKey() == null) {
			mfih004Form.setSearchKey("0");
		}

		PatientsHospitalizedEntity param = new PatientsHospitalizedEntity();
		param.setUserId(AhisCommonUtil.getCurrentUserInfo().getUserID());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if ("1".equals(mfih004Form.getSearchKey())) { // 3个月以内
			param.setInDate(sdf.format(DateUtils.addMonths(new Date(), -3)));
		} else if ("2".equals(mfih004Form.getSearchKey())) { // 1年以内
			param.setInDate(sdf.format(DateUtils.addYears(new Date(), -1)));
		} else if ("3".equals(mfih004Form.getSearchKey())) { // 3年以内
			param.setInDate(sdf.format(DateUtils.addYears(new Date(), -3)));
		}
		List<PatientsHospitalizedInfo> dtoList = mfih004Service.getHospitalizeByUserId(param);
		List<PatientsHospitalizedEntity> enList = new ArrayList<>();

		PatientsHospitalizedInfo dto;
		PatientsHospitalizedEntity entity;
		for (int i = 0, len = dtoList.size(); i < len; i++) {
			entity = new PatientsHospitalizedEntity();
			dto = dtoList.get(i);

			entity.setStayNo(dto.getStayNo());
			entity.setStatusFlg(dto.getStatusFlg());
			sdf = new SimpleDateFormat("yyyy年M月d日 EEEE");
			entity.setStartDate(sdf.format(dto.getInDate()));
			sdf = new SimpleDateFormat("yyyy年M月d日");
			entity.setInDate(sdf.format(dto.getInDate()));
			if (dto.getOutDate() != null) {
				entity.setOutDate(sdf.format(dto.getOutDate()));
			}
			entity.setArea(dto.getArea());
			entity.setBed(dto.getBed());
			entity.setNurseName("郝安心");
			entity.setTotalFee("15000");

			// 获取医生名称
			JSONObject json = new JSONObject();

				json.put("deptCode", dto.getDeptCode());
				json.put("doctorCode", dto.getDoctorCode());
				DoctorInfoItem doctor = mfih004Service.getDoctorInfo(json);
				entity.setDoctorName(doctor.getDoctorName());

			// 获取科室名称
			json = new JSONObject();

				json.put("deptCode", dto.getDeptCode());
				HospitalDeptItem dept = mfih004Service.getDeptInfo(json);
				entity.setDeptName(dept.getDeptName());

			enList.add(entity);
		}
		mfih004Form.setHospitalizedList(enList);
		return forwardIndex();
	}

}
