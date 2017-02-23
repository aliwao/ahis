package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mplg003Form;
import cn.com.liandisys.ahis.webapp.service.Mplg003Service;

/**
 * 个人信息页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mplg003/*")
public class Mplg003Controller extends AbstractAhisController<Mplg003Form> {

	/** Logger */
	private Logger logger = LoggerFactory.getLogger(Mplg003Controller.class);

	@Autowired
	private Mplg003Service mplg003Service;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mplg003Form initload(@ModelAttribute Mplg003Form f) {
        mplg003Service.initload(f);
        return f;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)  
    public String save(HttpServletRequest request, @ModelAttribute Mplg003Form f, RedirectAttributes attr) {
        mplg003Service.save(f);
        // 我的信息页面
        return "redirect:/g/mpmp001/index";
    }
}
