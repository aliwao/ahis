package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.AppointmentOrderEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg004Form;
import cn.com.liandisys.ahis.webapp.service.Mfrg004Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("m/mfrg004/*")
public class Mfrg004Controller extends AbstractAhisController<Mfrg004Form> {
	@Autowired
	private Mfrg004Service mfrg004Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfrg004Form mfrg004Form, HttpServletRequest req) {
		LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();
		mfrg004Form.setUserID(userInfo.getUserID());
		mfrg004Form.setUserName(userInfo.getName());
		String doctorName = mfrg004Form.getDoctorName();
		mfrg004Form.setIsExpert(doctorName != null && !doctorName.isEmpty());
		return forwardIndex();
	}

	@RequestMapping(value = "appoint", method = RequestMethod.POST)
	@ResponseBody
	public String appoint(@ModelAttribute Mfrg004Form mfrg004Form) {
		LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();
		AppointmentOrderEntity entiy = mfrg004Service.appoint(mfrg004Form, userInfo);
		if (null == entiy) {
			return "error";
		} else {
			return JSONObject.fromObject(entiy).toString();
		}
	}
}
