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
import cn.com.liandisys.ahis.webapp.form.Mpst003Form;
import cn.com.liandisys.ahis.webapp.service.Mpst003Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 密码修改页面
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mpst003/*")
public class Mpst003Controller extends AbstractAhisController<Mpst003Form> {

	@Autowired
	private Mpst003Service mpst003Service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value="initload", method = RequestMethod.POST) 
	@ResponseBody
    public Mpst003Form initload(@ModelAttribute Mpst003Form f) {
//        mpst002Service.initload(f);
        return f;
    }

    @RequestMapping(value="save", method = RequestMethod.POST)  
    public String save(HttpServletRequest request, @ModelAttribute Mpst003Form f, RedirectAttributes attr) {

        // 密码验证
        boolean chkflg = mpst003Service.checkPasswd(f);
        if(!chkflg){
            f.setMsg("原密码有误！");
            f.setMsgtype("error");
            return forwardIndex();
        }

        // 更新处理
        mpst003Service.save(f);
        // 更新后重新登录处理
        autoLogin(request);
        // 支付安全页面
        return "redirect:/m/mpst001/index";
    }

	/**
	 * 更新后重新登录处理
	 * @param request
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
