package cn.com.liandisys.ahis.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.form.UserInfo;

@Service
public class AuthService {

	Logger logger = LoggerFactory.getLogger(AuthService.class);

	@Cacheable(value = "userCache", keyGenerator = "keyGenerator")
	public UserInfo findUser(String telNo, String passWord) {
		logger.info("New User Info Cache.");
		UserInfo userInfo = new UserInfo();
		userInfo.setPassWord(telNo);
		userInfo.setPassWord(passWord);
		return userInfo;
	}
}
