package cn.com.liandisys.ahis.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.form.SmsCodeForm;
import cn.com.liandisys.ahis.webapp.service.SmsCodeService;

/**
 * 短信验证控制器
 * @version 1.0
 *
 */
@Controller
@RequestMapping("g/smscode/*")
public class SmsCodeController {

	/** Logger */
	private Logger logger = LoggerFactory.getLogger(SmsCodeController.class);

	@Autowired
	private SmsCodeService sendSmsVCode;

	@RequestMapping(value="send", method = RequestMethod.POST) 
	@ResponseBody
	public SmsCodeForm send(@ModelAttribute SmsCodeForm f) {
		String mobileNo = f.getMobileNo();
		boolean sendflg = sendSmsVCode.sendVCode(mobileNo);
		if(sendflg){
			logger.info("短信验证码发送成功！");
			f.setMsgType(0);
			f.setMessage("短信验证码发送成功！");
		}
		else {
			logger.error("短信验证码发送失败！");
			f.setMsgType(-1);
			f.setMessage("短信验证码发送失败！");
		}
		return f;
	}

	@RequestMapping(value="verify", method = RequestMethod.POST) 
	@ResponseBody
	public SmsCodeForm verify(@ModelAttribute SmsCodeForm f) {
		String mobileNo = f.getMobileNo();
		String inputVcode = f.getInputVcode();
		boolean chkflg = sendSmsVCode.verifyVCode(mobileNo, inputVcode);
		if(chkflg){
			logger.info("短信验证成功！");
			f.setMsgType(0);
			f.setMessage("短信验证成功！");
		}
		else {
			logger.error("短信验证失败！");
			f.setMsgType(-1);
			f.setMessage("短信验证失败！");
		}
		return f;
	}

}
