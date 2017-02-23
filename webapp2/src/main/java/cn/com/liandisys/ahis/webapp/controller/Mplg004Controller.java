package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.form.Mplg004Form;
import cn.com.liandisys.ahis.webapp.service.Mplg004Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;

/**
 * 密码重置页面注册器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("g/mplg004/*")
public class Mplg004Controller extends AbstractAhisController<Mplg004Form> {

	@Autowired
	private Mplg004Service mplg004Service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mplg004Form initload(@ModelAttribute Mplg004Form f) {
		mplg004Service.initload(f);
        return f;
    }

    @RequestMapping(value="verifyTelno", method = RequestMethod.POST) 
    @ResponseBody
    public boolean verifyTelno(@ModelAttribute Mplg004Form f) {
        return mplg004Service.verifyTelno(f);
    }

    @RequestMapping(value="save", method = RequestMethod.POST)  
    public String save(HttpServletRequest request, @ModelAttribute Mplg004Form f, RedirectAttributes attr) {

        // 更新处理
    	mplg004Service.save(f);
        // 更新后重新登录处理
        autoLogin(request);
        // 我的页面
        return "redirect:/g/mpmp001/index";
    }

	/**
	 * 更新后重新登录处理
	 * @param request
	 * @param f
	 * @param passwd
	 */
    private void autoLogin(HttpServletRequest request){
        LoginUserInfo userinfo = SessionService.getAttribute(AhisConstants.SESSION_KEY_USERINFO);
        String mobileNo = userinfo.getMobileNo();
        String passwd = userinfo.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(mobileNo, passwd);
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
