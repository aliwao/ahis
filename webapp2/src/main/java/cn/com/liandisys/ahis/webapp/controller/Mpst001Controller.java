package cn.com.liandisys.ahis.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mpst001Form;
import cn.com.liandisys.ahis.webapp.service.Mpst001Service;

/**
 * 支付安全页面
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mpst001/*")
public class Mpst001Controller extends AbstractAhisController<Mpst001Form> {

	@Autowired
	private Mpst001Service mpst001Service;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mpst001Form initload(@ModelAttribute Mpst001Form f) {
        mpst001Service.initload(f);
        return f;
    }

	/**
	 * 验证是否已经有绑定某卡
	 * 
	 * @param mpst004Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "checkBinding/{cardCd}", method = RequestMethod.POST)
	@ResponseBody
	public String checkBinding(@PathVariable("cardCd")String cardCd, @ModelAttribute Mpst001Form f) {
		// 业务处理
		String result = mpst001Service.checkBinding(cardCd);
		// 返回结果
		return result;
	}
}
