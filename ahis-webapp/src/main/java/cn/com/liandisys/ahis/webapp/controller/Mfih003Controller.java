package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.PatientsHospitalizedInfo;
import cn.com.liandisys.ahis.webapp.entity.PatientsHospitalizedEntity;
import cn.com.liandisys.ahis.webapp.form.Mfih003Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptItem;
import cn.com.liandisys.ahis.webapp.service.Mfih003Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 住院详细页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfih003/*")
public class Mfih003Controller extends AbstractAhisController<Mfih003Form> {

	/** 状态Flag 0:未入院 */
	private static String HOSPITAL_STAY = "1";

	@Autowired
	private Mfih003Service mfih003Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfih003Form mfih003Form, HttpServletRequest req) {
		PatientsHospitalizedEntity param = new PatientsHospitalizedEntity();
		param.setUserId(AhisCommonUtil.getCurrentUserInfo().getUserID());
		param.setStatusFlg(HOSPITAL_STAY);

		PatientsHospitalizedInfo result;
		if (mfih003Form.getStayNo() == null || mfih003Form.getStayNo().isEmpty()) {
			result = mfih003Service.getInfoByUserIdAndStatusFlg(param);
		} else {
			param.setStayNo(mfih003Form.getStayNo());
			result = mfih003Service.getInfoByStayNo(param);
		}

		if (result != null) {
			mfih003Form.setStatusFlg(result.getStatusFlg());
			mfih003Form.setStayNo(result.getStayNo());
			mfih003Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getName());
			mfih003Form.setHospitalName("无锡市第三人民医院");

			// 获取医生名称
			JSONObject json = new JSONObject();
			try {
				json.put("deptCode", result.getDeptCode());
				json.put("doctorCode", result.getDoctorCode());
				DoctorInfoItem doctor = mfih003Service.getDoctorInfo(json);
				mfih003Form.setDoctorName(doctor.getDoctorName());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			// 获取科室名称
			json = new JSONObject();
			try {
				json.put("deptCode", result.getDeptCode());
				HospitalDeptItem dept = mfih003Service.getDeptInfo(json);
				mfih003Form.setDeptName(dept.getDeptName());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			mfih003Form.setDiagnoseInfo(result.getDiagnoseInfo());
			mfih003Form.setArea(result.getArea());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 EEEE");
			if (result.getInDate() != null) {
				mfih003Form.setInDate(sdf.format(result.getInDate()));
			}
			if (result.getOutDate() != null) {
				mfih003Form.setOutDate(sdf.format(result.getOutDate()));
			}
			if (result.getAdvancedPay() != null) {
				mfih003Form.setAdvancedPay(result.getAdvancedPay().toString());
			} else {
				mfih003Form.setAdvancedPay("0");
			}
		}
		return forwardIndex();
	}

}
