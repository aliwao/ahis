package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mprg009Form;

/**
 * 我的挂号页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mprg009/*")
public class Mprg009Controller extends AbstractAhisController<Mprg009Form> {

//	@Autowired
//	private Mprg009Service mprg009Service;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mprg009Form initload(@ModelAttribute Mprg009Form f) {

        return f;
    }
}
