package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mpmp001Form;
import cn.com.liandisys.ahis.webapp.service.Mpmp001Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 我的信息页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("g/mpmp001/*")
public class Mpmp001Controller extends AbstractAhisController<Mpmp001Form> {

	@Autowired
	private Mpmp001Service mpmp001Service;

	@RequestMapping("index")
	public String index(@ModelAttribute(value="mpmp001Form") Mpmp001Form f, HttpServletRequest req) {
//		String message = (String)req.getParameter("message");
//		if(message != null){
//			try {
//				req.setAttribute("message", new String(message.getBytes("ISO8859_1"),"utf-8"));
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		}
		// 初期取得当前登录用户
		f.setMobileNo(AhisCommonUtil.getCurrentUsernameTelno());
		
		mpmp001Service.index(f);
		return "MPMP001";
	}
}
