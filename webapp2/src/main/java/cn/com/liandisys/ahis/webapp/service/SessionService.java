package cn.com.liandisys.ahis.webapp.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class SessionService {

	public static final Logger logger = LoggerFactory.getLogger(SessionService.class);

	public static void setAttribute(String sessionKey, Object value) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = sra.getRequest().getSession();
		logger.info(sra.getRequest().getSession().getId());
		session.setAttribute(sessionKey, value);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getAttribute(String sessionKey) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = sra.getRequest().getSession();
		logger.info(sra.getRequest().getSession().getId());
		return (T) session.getAttribute(sessionKey);
	}

	public static void removeAttribute(String sessionKey) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = sra.getRequest().getSession();
		logger.info(sra.getRequest().getSession().getId());
		session.removeAttribute(sessionKey);
	}
}
