package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.form.Rsrs001Form;
import cn.com.liandisys.ahis.webapp.form.Rsrs003Form;
import cn.com.liandisys.ahis.webapp.service.Rsrs003Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;

@Controller
@RequestMapping("/m/rsrs003/*")
public class Rsrs003Controller extends AbstractAhisController<Rsrs003Form> {

	@Autowired
	Rsrs003Service rsrs003Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param rsrs003Form
	 */
	@RequestMapping("init")
	public String init(@ModelAttribute Rsrs003Form rsrs003Form, HttpServletRequest req, String itemId) {

		Rsrs001Form sessionForm = SessionService.getAttribute(AhisConstants.SESSION_KEY_RSRS001);

		String checkId = sessionForm.getHidCheckId();

		rsrs003Form = rsrs003Service.init(rsrs003Form, checkId, itemId);

		return forwardIndex();
	}
}
