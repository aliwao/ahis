package cn.com.liandisys.ahis.webapp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.com.liandisys.ahis.webapp.constants.AhisConstants;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.service.SessionService;

public class AhisCommonUtil {

	private static final Logger logger = LoggerFactory.getLogger(AhisCommonUtil.class);

	/**
	 * 取得当前已登录的用户名（未登录的场合返回空）
	 * @return 当前已登录的用户名(手机号码)
	 */
	public static String getCurrentUsernameTelno() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		logger.debug("当前用户名：" + username);
		if("anonymousUser".equals(username)) {
			username = null;
		}
		return username;
	}

	/**
	 * 取得当前登录的用户信息
	 * @return 当前登录的用户信息
	 */
	public static LoginUserInfo getCurrentUserInfo() {
		// 取得当前登录的用户信息
		LoginUserInfo userinfo = null;
		if(getCurrentUsernameTelno() != null) {
			userinfo = SessionService.getAttribute(AhisConstants.SESSION_KEY_USERINFO);
		}
		return userinfo;
	}
}
