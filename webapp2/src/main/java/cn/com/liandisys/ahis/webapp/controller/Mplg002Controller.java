package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import cn.com.liandisys.ahis.webapp.form.Mplg002Form;
import cn.com.liandisys.ahis.webapp.service.Mplg002Service;
import cn.com.liandisys.ahis.webapp.service.SessionService;

/**
 * 注册页面控制器
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("g/mplg002/*")
public class Mplg002Controller extends AbstractAhisController<Mplg002Form> {

	/** Logger */
	private Logger logger = LoggerFactory.getLogger(Mplg002Controller.class);

	@Autowired
	private Mplg002Service mplg002Service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value="verifyTelno", method = RequestMethod.POST) 
	@ResponseBody
	public boolean verifyTelno(@ModelAttribute Mplg002Form f) {
		return mplg002Service.verifyTelno(f);
	}

	@RequestMapping(value="verifyIdentityCardNo", method = RequestMethod.POST) 
	@ResponseBody
	public boolean verifyIdentityCardNo(@ModelAttribute Mplg002Form f) {
		return mplg002Service.verifyIdentityCardNo(f);
	}

	@RequestMapping(value="save", method = RequestMethod.POST)  
    public String save(HttpServletRequest request, @ModelAttribute Mplg002Form form, RedirectAttributes attr)
                   throws Exception {
            logger.info(form.getTelno());
            logger.info(form.getUsername());
            logger.info(form.getSfzhaoma());
            mplg002Service.insert(form);
            //attr.addAttribute("telno", form.getTelno());
            attr.addFlashAttribute("msg", "恭喜您已注册成功！");
            attr.addFlashAttribute("msgtype", "success");
            // 注册后自动登录
            autoLogin(request);
            // 我的信息页面
            return "redirect:/g/mpmp001/index";
    }

	/**
	 * 注册后自动登录处理
	 * @param request
	 */
    private void autoLogin(HttpServletRequest request){
        LoginUserInfo userinfo = (LoginUserInfo)SessionService.getAttribute(AhisConstants.SESSION_KEY_USERINFO);
        String mobileNo = userinfo.getMobileNo();
        System.out.println(mobileNo);
        String passwd = userinfo.getPassword();
        System.out.println(passwd);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(mobileNo, passwd);
        //HttpServletRequest request = ServletActionContext.getRequest();
        // generate session if one doesn't exist
        request.getSession();

        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
}
