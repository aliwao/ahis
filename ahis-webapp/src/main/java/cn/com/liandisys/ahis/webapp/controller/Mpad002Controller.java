package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mpad002Form;
import cn.com.liandisys.ahis.webapp.service.Mpad002Service;

/**
 * 我的地址增加/修改页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mpad002/*")
public class Mpad002Controller extends AbstractAhisController<Mpad002Form> {

	@Autowired
	private Mpad002Service mpad002Service;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mpad002Form initload(@ModelAttribute Mpad002Form f) {
		mpad002Service.initload(f);
        return f;
    }

    @RequestMapping(value="save", params = {"action=save"}, method = RequestMethod.POST)
    public String save(HttpServletRequest request, @ModelAttribute Mpad002Form f, RedirectAttributes attr) {
        mpad002Service.save(f);
        // 我的地址一览页面
        return "redirect:/m/mpad001/index";
    }

    @RequestMapping(value="save", params = {"action=delete"}, method = RequestMethod.POST)
    public String delete(HttpServletRequest request, @ModelAttribute Mpad002Form f, RedirectAttributes attr) {
        mpad002Service.delete(f);
        // 我的地址一览页面
        return "redirect:/m/mpad001/index";
    }
}
