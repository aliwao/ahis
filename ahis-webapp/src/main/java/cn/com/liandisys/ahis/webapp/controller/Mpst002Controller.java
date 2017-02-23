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
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.form.Mpst002Form;
import cn.com.liandisys.ahis.webapp.service.Mpst002Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 手机号码修改页面
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mpst002/*")
public class Mpst002Controller extends AbstractAhisController<Mpst002Form> {

	@Autowired
	private Mpst002Service mpst002Service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mpst002Form initload(@ModelAttribute Mpst002Form f) {
        mpst002Service.initload(f);
        return f;
    }

    @RequestMapping(value="verifyTelno", method = RequestMethod.POST) 
    @ResponseBody
    public boolean verifyTelno(@ModelAttribute Mpst002Form f) {
        return mpst002Service.verifyTelno(f);
    }

    @RequestMapping(value="save", method = RequestMethod.POST)  
    public String save(HttpServletRequest request, @ModelAttribute Mpst002Form f, RedirectAttributes attr) {

        // 更新处理
        mpst002Service.save(f);
        // 更新后重新登录处理
        autoLogin(request);
        // 支付安全页面
        return "redirect:/m/mpst001/index";
    }

	/**
	 * 更新后重新登录处理
	 * @param request
	 * @param f
	 * @param passwd
	 */
    private void autoLogin(HttpServletRequest request){
        LoginUserInfo userinfo = AhisCommonUtil.getCurrentUserInfo();
        String mobileNo = userinfo.getMobileNo();
        String passwd = userinfo.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(mobileNo, passwd);
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
