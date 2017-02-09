package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfrg005Form;
import cn.com.liandisys.ahis.webapp.service.Mfrg005Service;

@Controller
@RequestMapping("m/mfrg005/*")
public class Mfrg005Controller extends AbstractAhisController<Mfrg005Form> {
	@Autowired
	private Mfrg005Service mfrg005Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfrg005Form mfrg005Form, HttpServletRequest req) {
		return forwardIndex();
	}

	@ResponseBody
	@RequestMapping(value="updateStatus",method = RequestMethod.POST)
	public String updateStatus(@ModelAttribute Mfrg005Form mfrg005Form) {
		mfrg005Service.updateStatus(mfrg005Form,"2");
		return null;
	}
}
