package cn.com.liandisys.ahis.webapp.auth;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.UserInfoEntity;
import cn.com.liandisys.ahis.webapp.entity.UserLoginEntity;
import cn.com.liandisys.ahis.webapp.mapper.UserInfoMapper;
import cn.com.liandisys.ahis.webapp.mapper.UserLoginMapper;
import cn.com.liandisys.ahis.webapp.service.SessionService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

@Component
public class AhisAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	@Qualifier("userLoginMapper")
	private UserLoginMapper userLoginMapper;

	@Autowired
	@Qualifier("userInfoMapper")
	private UserInfoMapper userInfoMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,  
        HttpServletResponse response, Authentication auth)
        throws IOException, ServletException {
         // 登录成功时，向Session里保存用户信息
         UserLoginEntity userLoginInfo = userLoginMapper.getByMobileNo(AhisCommonUtil.getCurrentUsernameTelno());
         if(userLoginInfo != null){
             LoginUserInfo userinfo = new LoginUserInfo();
             BeanUtils.copyProperties(userLoginInfo, userinfo);
             UserInfoEntity userDetailInfo = userInfoMapper.selectByPrimaryKey(Long.valueOf(userinfo.getUserID()));
             if(userDetailInfo != null){
                BeanUtils.copyProperties(userDetailInfo, userinfo);
             }
             SessionService.setAttribute(AhisConstants.SESSION_KEY_USERINFO, userinfo);
         }

         // 登录成功后画面表示
         String osname = request.getParameter("osname");  
         if (StringUtils.isNotEmpty(osname)) {
             if(osname.equals("android")){
                 response.setCharacterEncoding("UTF-8");  
                 response.getWriter().write("登录成功"+AhisCommonUtil.getCurrentUsernameTelno());  
             }
         } else {
            String frontUrl = (String)request.getSession().getAttribute("frontUrl");  
            request.getSession().removeAttribute("frontUrl");  
            if(StringUtils.isNotEmpty(frontUrl)){
                response.sendRedirect(frontUrl);  
                //request.getRequestDispatcher(frontUrl).forward(request, response);  
            } else {
                String message = URLEncoder.encode("登录成功！","utf-8");
                response.sendRedirect("g/mpmp001/index?message=" + message);
                //request.setAttribute("message", "登录成功！");
                //request.getRequestDispatcher("g/mpmp001/index").forward(request, response);  
            }
         }
    }
}
