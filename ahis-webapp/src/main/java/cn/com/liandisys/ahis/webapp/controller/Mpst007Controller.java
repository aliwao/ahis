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
import cn.com.liandisys.ahis.webapp.form.Mpst007Form;
import cn.com.liandisys.ahis.webapp.service.Mpst006Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 银行卡详情页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mpst007/*")
public class Mpst007Controller extends AbstractAhisController<Mpst007Form> {

	@Autowired
	private Mpst006Service mfrg006Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mpst007Form mpst007Form, HttpServletRequest req) {

		LoginUserInfo loginUser = AhisCommonUtil.getCurrentUserInfo();
		BankCardInfoEntity param = new BankCardInfoEntity();
		param.setUserId(new Long(loginUser.getUserID()));
		param.setBankCardNo(mpst007Form.getBankCardNo());
		BankCardInfoEntity entity = mfrg006Service.getCardByPrimaryKey(param);

		if (entity != null) {
			// TODO 真实银行卡号
			if ("1".equals(entity.getBank())) {
				mpst007Form.setBank("中国银行");
				mpst007Form.setBankIconImg("/images/bankicon/boc.jpg");
			} else if ("2".equals(entity.getBank())) {
				mpst007Form.setBank("中国工商银行");
				mpst007Form.setBankIconImg("/images/bankicon/icbc.jpg");
			} else if ("3".equals(entity.getBank())) {
				mpst007Form.setBank("中国建设银行");
				mpst007Form.setBankIconImg("/images/bankicon/ccb.jpg");
			} else if ("4".equals(entity.getBank())) {
				mpst007Form.setBank("招商银行");
				mpst007Form.setBankIconImg("/images/bankicon/cmb.jpg");
			}

			if ("1".equals(entity.getBankCardType())) {
				mpst007Form.setBankCardType("借记卡");
			} else if ("2".equals(entity.getBankCardType())) {
				mpst007Form.setBankCardType("信用卡");
			}
			// TODO 真实身份证姓名即持卡人姓名
			mpst007Form.setOwnCardName(entity.getOwnCardName());
			mpst007Form.setBankCardNo(entity.getBankCardNo());
			mpst007Form.setPhoneNo(entity.getPhoneNo().substring(0, 3).concat("****")
					.concat(entity.getPhoneNo().substring(entity.getPhoneNo().length() - 4)));
		}
		return forwardIndex();
	}

	/**
	 * 解除银行卡绑定处理。
	 * 
	 * @param mpst007Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "unbind", method = RequestMethod.POST)
	@ResponseBody
	public String unbind(@ModelAttribute Mpst007Form mpst007Form) {

		BankCardInfoEntity param = new BankCardInfoEntity();
		param.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		param.setBankCardNo(mpst007Form.getBankCardNo().trim().replace(" ", ""));

		BankCardInfoEntity entity = mfrg006Service.getCardByPrimaryKey(param);
		if (entity == null) {
			return "该银行卡未被绑定，不可解除绑定！";
		}

		// 业务处理 删除DB
		int result = mfrg006Service.deleteByPrimaryKey(param);
		if (result == 0) {
			return "对不起，绑定失败！";
		}
		// 解除绑定成功
		return "";
	}


}
