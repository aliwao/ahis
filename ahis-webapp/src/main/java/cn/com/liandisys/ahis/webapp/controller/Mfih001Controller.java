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
import cn.com.liandisys.ahis.webapp.form.Mfih001Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.DoctorInfoItem;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalDeptItem;
import cn.com.liandisys.ahis.webapp.service.Mfih001Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 入院缴费页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfih001/*")
public class Mfih001Controller extends AbstractAhisController<Mfih001Form> {

	/** 状态Flag 0:未入院 */
	private static String HOSPITAL_NOTIN = "0";

	@Autowired
	private Mfih001Service mfih001Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfih001Form mfih001Form, HttpServletRequest req) {
		PatientsHospitalizedEntity param = new PatientsHospitalizedEntity();
		param.setUserId(AhisCommonUtil.getCurrentUserInfo().getUserID());
		param.setStatusFlg(HOSPITAL_NOTIN);

		PatientsHospitalizedInfo result = mfih001Service.getInfoByUserIdAndStatusFlg(param);
		if (result != null) {
			mfih001Form.setStayNoD(result.getStayNo());
			mfih001Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getName());
			mfih001Form.setHospitalName("无锡市第三人民医院");

			// 获取医生名称
			JSONObject json = new JSONObject();
			try {
				json.put("deptCode", result.getDeptCode());
				json.put("doctorCode", result.getDoctorCode());
				DoctorInfoItem doctor = mfih001Service.getDoctorInfo(json);
				mfih001Form.setDoctorName(doctor.getDoctorName());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			// 获取科室名称
			json = new JSONObject();
			try {
				json.put("deptCode", result.getDeptCode());
				HospitalDeptItem dept = mfih001Service.getDeptInfo(json);
				mfih001Form.setDeptName(dept.getDeptName());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (JAXBException e) {
				e.printStackTrace();
			}

			mfih001Form.setDiagnoseInfo(result.getDiagnoseInfo());
			mfih001Form.setArea(result.getArea());
			if (result.getInDate() != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 EEEE");
				mfih001Form.setInDate(sdf.format(result.getInDate()));
			}
			if (result.getAdvancedPay() != null) {
				mfih001Form.setAdvancedPay(result.getAdvancedPay().toString());
			} else {
				mfih001Form.setAdvancedPay("0");
			}
		}
		return forwardIndex();
	}

}
