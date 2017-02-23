package cn.com.liandisys.ahis.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.webapp.component.SendSmsComponent;
import cn.com.liandisys.ahis.webapp.utils.RedisUtil;

@Service
public class SmsCodeService {

	/** logger */
	private static final Logger logger = LoggerFactory.getLogger(SmsCodeService.class);

	@Autowired
	private RedisUtil redisUtil;

	@Autowired
	private SendSmsComponent sendSmsComponent;

	//@Cacheable(value="smscode")
	public boolean sendVCode(String mobileNo){
		// 以手机号码为key，从缓存数据库里获取对应的验证码
		String vcode = redisUtil.getString(mobileNo);
		if(vcode == null || "".equals(vcode)){
			// 获取4位随机数字验证码
			vcode = getRandom();
		}
		// 以手机号码为key，向缓存数据库里保存验证码(5min有效)
		redisUtil.set(mobileNo, vcode, 300L);
		logger.debug("手机号码：" + mobileNo + "，生成的验证码：" + vcode);

		// 发送短信验证码
		boolean sendflg = sendSmsComponent.sendSmsCode(mobileNo, vcode);
		System.out.println(sendflg);
		return true;
	}

	//@Cacheable(value="smscode")
	public boolean verifyVCode(String mobileNo, String mycode){
		boolean result = false;
		// 以手机号码为key，从缓存数据库里获取对应的验证码
		String vcode = redisUtil.getString(mobileNo);
		logger.debug("手机号码：" + mobileNo + "，取得的验证码：" + vcode);
		if (vcode.equals(mycode)) {
			result = true;
			redisUtil.remove(mobileNo);
		}
		return result;
	}

	/**
	 * 获取4位随机验证码
	 * @return
	 */
	private String getRandom() {
		return getRandom(4);
	}

	/**
	 * 获取n位随机验证码
	 * @return
	 */
	private String getRandom(int n) {
		String num = "";
		for (int i = 0 ; i < n ; i ++) {
			num = num + String.valueOf((int) Math.floor(Math.random() * 9 + 1));
		}
		return num;
	}
}
