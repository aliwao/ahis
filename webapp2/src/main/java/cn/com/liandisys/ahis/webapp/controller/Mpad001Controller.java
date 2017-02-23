package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mpad001Form;
import cn.com.liandisys.ahis.webapp.service.Mpad001Service;

/**
 * 我的地址页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mpad001/*")
public class Mpad001Controller extends AbstractAhisController<Mpad001Form> {

	@Autowired
	private Mpad001Service mpad001Service;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mpad001Form initload(@ModelAttribute Mpad001Form f) {
		mpad001Service.initload(f);
        return f;
    }
}
