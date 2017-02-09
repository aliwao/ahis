package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.entity.HospitalOrderEntity;
import cn.com.liandisys.ahis.webapp.form.Mfop002Form;
import cn.com.liandisys.ahis.webapp.service.Mfop001Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;

@Controller
@RequestMapping("/m/mfop002/*")
public class Mfop002Controller extends AbstractAhisController<Mfop002Form> {

	@Autowired
	Mfop001Service paymentService;

	/**
	 * 画面初期化处理。
	 * 
	 * @param mfop002Form
	 */
	@RequestMapping("index")
	public String index(@ModelAttribute Mfop002Form mfop002Form, HttpServletRequest req) {

		HospitalOrderEntity hisOrdInfo = SessionService.getAttribute(AhisConstants.SESSION_KEY_MFOP001);
		mfop002Form.setPayName(hisOrdInfo.getPayName());
		mfop002Form.setTotalAmt(hisOrdInfo.getTotalAmt());
		mfop002Form.setMedInsAmt(hisOrdInfo.getMedIns_all());
		mfop002Form.setSelfAmt(hisOrdInfo.getSelfAmt_all());
		return forwardIndex();
	}
	
	/**
	 * 缴费处理。
	 * 
	 * @param mfop002Form
	 */
	@RequestMapping("doChoosePayWay")
	public String doPay(@ModelAttribute Mfop002Form mfop002Form) {

		return "redirect:/m/mfop003/index";
	}
}
