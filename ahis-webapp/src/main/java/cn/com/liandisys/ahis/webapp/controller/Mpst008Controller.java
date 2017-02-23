package cn.com.liandisys.ahis.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.entity.BankCardInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mpst008Form;
import cn.com.liandisys.ahis.webapp.service.Mpst006Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 添加银行卡页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mpst008/*")
public class Mpst008Controller extends AbstractAhisController<Mpst008Form> {

	@Autowired
	private Mpst006Service mfrg006Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mpst008Form mpst008Form, HttpServletRequest req) {
		LoginUserInfo loginUser = AhisCommonUtil.getCurrentUserInfo();
		mpst008Form.setIdCardNo(loginUser.getIdentityCardNo());
		mpst008Form.setOwnCardName(loginUser.getFullName()); // TODO 真实持卡姓名即身份证姓名
		return forwardIndex();
	}


	/**
	 * 银行卡绑定处理。
	 * 
	 * @param mpst008Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "bind", method = RequestMethod.POST)
	@ResponseBody
	public String bind(@ModelAttribute Mpst008Form mpst008Form) {
		LoginUserInfo loginUser = AhisCommonUtil.getCurrentUserInfo();

		BankCardInfoEntity param = new BankCardInfoEntity();
		param.setUserId(new Long(loginUser.getUserID()));
		param.setBankCardNo(mpst008Form.getBankCardNo());
		BankCardInfoEntity entity = mfrg006Service.getCardByPrimaryKey(param);
		if (entity != null) {
			return "该银行卡已被绑定，不可重复绑定！";
		}
		System.out.println(">>>>bank>>>>>>" + mpst008Form.getBank());
		param.setBank(mpst008Form.getBank());
		param.setBankCardType("1"); // TODO 真实银行卡类型 1：借记卡 2：信用卡 等。
		param.setOwnCardName(loginUser.getFullName()); // TODO 真实持卡姓名即身份证姓名
		param.setIdCardNo(loginUser.getIdentityCardNo());
		param.setPhoneNo(mpst008Form.getPhoneNo());

		// 业务处理 存入DB
		int result = mfrg006Service.insert(param);
		if (result == 0) {
			return "对不起，绑定失败！";
		}
		// 绑定成功
		return "";
	}
}
