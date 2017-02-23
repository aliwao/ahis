package cn.com.liandisys.ahis.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.liandisys.ahis.webapp.service.AuthService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	AuthService authService;

	@RequestMapping("/login")
	public String login(RedirectAttributes attr){
		String username = AhisCommonUtil.getCurrentUsernameTelno();
		if(username != null && !"".equals(username)){
			logger.info(username);
			logger.info("已登录，跳转至我的首页.");
			// 登录狀態
			attr.addFlashAttribute("isloginflg", "1");
			return "redirect:/g/mpmp001/index";
		}
		else {
			logger.info("您尚未登录！");
		}
//		UserLoginEntity userLoginInfo = SessionService.getAttribute(AhisConstants.SESSION_KEY_USERINFO);
//		if (userLoginInfo != null) {
//			logger.info("已登录，跳转至首页.");
//			return "index";
//		}
		return "MPLG001";
	}

//	@RequestMapping("/loginValid")
//	public String loginVaild(RedirectAttributes attr){
//		
//		// 登录狀態
//		attr.addFlashAttribute("isloginflg", "1");
//		attr.addFlashAttribute("msg", "登录成功！");
//		attr.addFlashAttribute("msgtype", "success");
//		return "redirect:/g/mpmp001/index";
//	}

	@RequestMapping("/logout")
	public String logout(RedirectAttributes attr){
		attr.addFlashAttribute("isloginflg", "0");
		return "redirect:/g/mpmp001/index";
	}

//	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
//	public UserInfo Login(HttpServletRequest request, @ModelAttribute UserInfo userInfo) {
//
//		UserLoginEntity userLoginInfo = SessionService.getAttribute(AhisConstants.SESSION_KEY_USERINFO);
//		if (userLoginInfo != null) {
//			logger.info("已经登录，不再重复验证.");
//			userInfo.setTelNo(userLoginInfo.getName());
//		} else {
//			userLoginInfo = userLoginService.getByMobileNo(userInfo.getTelNo());
//			if (userLoginInfo == null) {
//				userInfo.setTelNo("查无此人！");
//			} else {
//				userInfo.setTelNo(userLoginInfo.getName());
//				SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userLoginInfo);
//			}
//		}
//
//		return userInfo;
//	}
}
