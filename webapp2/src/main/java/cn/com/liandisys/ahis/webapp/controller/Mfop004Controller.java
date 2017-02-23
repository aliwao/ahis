package cn.com.liandisys.ahis.webapp.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfop004Form;
import cn.com.liandisys.ahis.webapp.service.Mfop004Service;

@Controller
@RequestMapping("/m/mfop004/*")
public class Mfop004Controller extends AbstractAhisController<Mfop004Form> {

	@Autowired
	Mfop004Service mfop004Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param mfop004Form
	 */
	@RequestMapping("init")
	public String init(@ModelAttribute Mfop004Form mfop004Form, HttpServletRequest req, int hisOrdNum, String patCardNo,
			String patCardType) {

		mfop004Form = mfop004Service.init(mfop004Form, hisOrdNum, patCardNo, patCardType);

		return forwardIndex();
	}

}
