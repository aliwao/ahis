package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.form.Rsrs001Form;
import cn.com.liandisys.ahis.webapp.form.Rsrs002Form;
import cn.com.liandisys.ahis.webapp.service.Rsrs002Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;

@Controller
@RequestMapping("/m/rsrs002/*")
public class Rsrs002Controller extends AbstractAhisController<Rsrs002Form> {

	@Autowired
	Rsrs002Service rsrs002Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param rsrs002Form
	 */
	@RequestMapping("index")
	public String index(@ModelAttribute Rsrs002Form rsrs002Form, HttpServletRequest req) {

		Rsrs001Form sessionForm = SessionService.getAttribute(AhisConstants.SESSION_KEY_RSRS001);

		String checkId = sessionForm.getHidCheckId();
		String reportType = sessionForm.getHidReportType();

		rsrs002Form = rsrs002Service.init(rsrs002Form, checkId, reportType);

		return forwardIndex();
	}

	/**
	 * 检查报告详细迁移。
	 * 
	 * @param rsrs002Form
	 */
	@RequestMapping(value = "goDetail")
	public String goDetail(@ModelAttribute Rsrs002Form rsrs002Form, HttpServletRequest req) {

		String itemId = rsrs002Form.getHidItemId();

		return "redirect:/m/rsrs003/init?itemId=" + itemId;
	}
}
