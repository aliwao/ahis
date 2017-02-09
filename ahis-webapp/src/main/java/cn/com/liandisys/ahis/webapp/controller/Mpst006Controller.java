package cn.com.liandisys.ahis.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.BankCardInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mpst006Form;
import cn.com.liandisys.ahis.webapp.service.Mpst006Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 我的银行卡页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mpst006/*")
public class Mpst006Controller extends AbstractAhisController<Mpst006Form> {

	@Autowired
	private Mpst006Service mfrg006Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mpst006Form mpst006Form, HttpServletRequest req) {
		List<BankCardInfoEntity> bankCardList = mfrg006Service.getCardsByUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));

		bankCardList.forEach(item -> {
			// TODO 真实银行卡号
				if ("1".equals(item.getBank())) {
					item.setBank("中国银行");
					item.setBankIconImg("/images/bankicon/boc.jpg");
				} else if ("2".equals(item.getBank())) {
					item.setBank("中国工商银行");
					item.setBankIconImg("/images/bankicon/icbc.jpg");
				} else if ("3".equals(item.getBank())) {
					item.setBank("中国建设银行");
					item.setBankIconImg("/images/bankicon/ccb.jpg");
				} else if ("4".equals(item.getBank())) {
					item.setBank("招商银行");
					item.setBankIconImg("/images/bankicon/cmb.jpg");
				}
				// TODO 真实 银行卡类型
				if ("1".equals(item.getBankCardType())) {
					item.setBankCardType("借记卡");
				} else if ("2".equals(item.getBankCardType())) {
					item.setBankCardType("信用卡");
				}
			});
		mpst006Form.setBankCardList(bankCardList);
		return forwardIndex();
	}

}
