package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mpfa001Form;
import cn.com.liandisys.ahis.webapp.service.Mpfa001Service;

/**
 * 我的收藏页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mpfa001/*")
public class Mpfa001Controller extends AbstractAhisController<Mpfa001Form> {

	@Autowired
	private Mpfa001Service mpfa001Service;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mpfa001Form initload(@ModelAttribute Mpfa001Form f) {
		mpfa001Service.initload(f);
        return f;
    }
}
