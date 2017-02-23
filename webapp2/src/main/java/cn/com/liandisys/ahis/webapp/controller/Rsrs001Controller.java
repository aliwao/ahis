package cn.com.liandisys.ahis.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.entity.InspReportEntity;
import cn.com.liandisys.ahis.webapp.entity.InspResultEntity;
import cn.com.liandisys.ahis.webapp.entity.PhyExamReportEntity;
import cn.com.liandisys.ahis.webapp.form.Rsrs001Form;
import cn.com.liandisys.ahis.webapp.service.Rsrs001Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;

@Controller
@RequestMapping("/m/rsrs001/*")
public class Rsrs001Controller extends AbstractAhisController<Rsrs001Form> {

	@Autowired
	Rsrs001Service rsrs001Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param rsrs001Form
	 */
	@RequestMapping("index")
	public String index(@ModelAttribute Rsrs001Form rsrs001Form, HttpServletRequest req) {

		rsrs001Form = rsrs001Service.init(rsrs001Form);

		SessionService.setAttribute(AhisConstants.SESSION_KEY_RSRS001, rsrs001Form);
		return forwardIndex();
	}

	/**
	 * 检查报告详细迁移。
	 * 
	 * @param rsrs001Form
	 */
	@RequestMapping(value = "goDetail")
	public String goDetail(@ModelAttribute Rsrs001Form rsrs001Form, HttpServletRequest req) {

		Rsrs001Form sessionForm = SessionService.getAttribute(AhisConstants.SESSION_KEY_RSRS001);
		sessionForm.setHidCheckId(rsrs001Form.getHidCheckId());
		sessionForm.setHidPatCardNo(rsrs001Form.getHidPatCardNo());
		sessionForm.setHidPatCardType(rsrs001Form.getHidPatCardType());
		sessionForm.setHidReportType(rsrs001Form.getHidReportType());

		SessionService.setAttribute(AhisConstants.SESSION_KEY_RSRS001, sessionForm);

		return "redirect:/m/rsrs002/index";
	}

	/**
	 * 利用检索ID检索报告。
	 * 
	 * @param rsrs001Form
	 */
	@RequestMapping(value = "select")
	public String select(@ModelAttribute Rsrs001Form rsrs001Form, HttpServletRequest req, String checkId) {

		Rsrs001Form sessionForm = SessionService.getAttribute(AhisConstants.SESSION_KEY_RSRS001);

		List<InspResultEntity> inspResultList = sessionForm.getInspResultList();
		List<InspResultEntity> newResultList = new ArrayList<>();
		for (InspResultEntity entity : inspResultList) {
			if (checkId.equals(entity.getCheckId())) {
				newResultList.add(entity);
				rsrs001Form.setInspResultList(newResultList);
			}
		}

		List<InspReportEntity> inspReportList = sessionForm.getInspReportList();
		List<InspReportEntity> newReportList = new ArrayList<>();
		for (InspReportEntity entity : inspReportList) {
			if (checkId.equals(entity.getInspectId())) {
				newReportList.add(entity);
				rsrs001Form.setInspReportList(newReportList);
			}
		}

		List<PhyExamReportEntity> phyExamList = sessionForm.getPhyExamReportList();
		List<PhyExamReportEntity> newphyExamList = new ArrayList<>();
		for (PhyExamReportEntity entity : phyExamList) {
			if (checkId.equals(entity.getPhyExamId())) {
				newphyExamList.add(entity);
				rsrs001Form.setPhyExamReportList(newphyExamList);
			}
		}
		
		if(newResultList.isEmpty()&&newReportList.isEmpty()&&newphyExamList.isEmpty()){
			rsrs001Form.setHidReportFlag("0");
		}else{
			rsrs001Form.setHidReportFlag("1");
		}

		return forwardIndex();
	}
}
