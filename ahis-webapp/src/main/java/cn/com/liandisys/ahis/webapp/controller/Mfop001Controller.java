package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfop001Form;
import cn.com.liandisys.ahis.webapp.service.Mfop001Service;

@Controller
@RequestMapping("/m/mfop001/*")
public class Mfop001Controller extends AbstractAhisController<Mfop001Form> {

	@Autowired
	private Mfop001Service mfop001Service;

	/**
	 * 画面初期化处理。
	 * 
	 * @param mfop001Form
	 */
	@RequestMapping("init")
	public String init(@ModelAttribute Mfop001Form mfop001Form, HttpServletRequest req) {

		// TODO 医保余额无取得接口
		mfop001Form.setBalance("500.00");

		mfop001Form = mfop001Service.init(mfop001Form);

		/*if (isPaid != null) {
			mfop001Form.setIsPaid(isPaid);
		} else {
			mfop001Form.setIsPaid("2");
		}*/
		return "MFOP001";
	}

	/**
	 * 缴费处理。
	 * 
	 * @param mfop001Form
	 * @throws JAXBException
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping(value = "doPay")
	public RedirectView doPay(@ModelAttribute Mfop001Form mfop001Form) throws ParseException {

		RedirectView mav = mfop001Service.doPay(mfop001Form);

		return mav;
	}

	/**
	 * 缴费详细迁移。
	 * 
	 * @param mfop001Form
	 */
	@RequestMapping(value = "goDetail")
	public String goDetail(@ModelAttribute Mfop001Form mfop001Form, HttpServletRequest req) {

		String hisOrdNum = mfop001Form.getHidHisOrdNum();
		String patCardNo = mfop001Form.getHidPatCardNo();
		String patCardType = mfop001Form.getHidPatCardType();

		return "redirect:/m/mfop004/init?hisOrdNum=" + hisOrdNum + "&patCardNo=" + patCardNo + "&patCardType="
				+ patCardType;
	}
}
