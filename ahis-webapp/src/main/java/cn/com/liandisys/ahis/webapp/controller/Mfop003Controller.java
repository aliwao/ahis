package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop003Form;
import cn.com.liandisys.ahis.webapp.service.Mfop003Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Controller
@RequestMapping("/m/mfop003/*")
public class Mfop003Controller extends AbstractAhisController<Mfop003Form> {

	@Autowired
	Mfop003Service mfop003Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param mfop003Form
	 */
	@RequestMapping("index")
	public String index(@ModelAttribute Mfop003Form mfop003Form, HttpServletRequest req) {

		return forwardIndex();
	}

	/**
	 * 支付处理。
	 * 
	 * @param mfop003Form
	 */
	@RequestMapping("doPay")
	@ResponseBody
	public int doPay(@ModelAttribute Mfop003Form mfop003Form, HttpServletRequest req) {

		HospitalOrderEntity hisOrdInfo = SessionService.getAttribute(AhisConstants.SESSION_KEY_MFOP001);

		LoginUserInfo userInfo = AhisCommonUtil.getCurrentUserInfo();
		hisOrdInfo.setUserId(userInfo.getUserID());

		int count = mfop003Service.select(hisOrdInfo);

		if (count == 0) {
			return mfop003Service.insert(hisOrdInfo);
		} else {
			return 0;
		}
	}
}
