package cn.com.liandisys.ahis.webapp.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.entity.HospitalCardInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mpst005Form;
import cn.com.liandisys.ahis.webapp.service.Mpst005Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 就诊卡绑定页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mpst005/*")
public class Mpst005Controller extends AbstractAhisController<Mpst005Form> {

	@Autowired
	private Mpst005Service mfrg005Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mpst005Form mpst005Form, HttpServletRequest req) {
		String cardNo = mfrg005Service.getCardByUserId(AhisCommonUtil.getCurrentUserInfo().getUserID());
		if (StringUtils.isNotEmpty(cardNo)) {
			mpst005Form.setPatCardNo(cardNo);
			mpst005Form.setExistCard("1");
		}
		return forwardIndex();
	}

	/**
	 * 就诊卡绑定处理。
	 * 
	 * @param mpst005Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "bind", method = RequestMethod.POST)
	@ResponseBody
	public String bind(@ModelAttribute Mpst005Form mpst005Form) {
		HospitalCardInfoEntity paramEntity = new HospitalCardInfoEntity();
		paramEntity.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		paramEntity.setJiuzhenkahao(mpst005Form.getPatCardNo());
		paramEntity.setInsertTimeStamp(new Timestamp(System.currentTimeMillis()));

		HospitalCardInfoEntity entity = mfrg005Service.getCardByPrimaryKey(paramEntity);
		if (entity != null) {
			return "该就诊卡已被绑定，不可再次绑定!";
		}
		// 业务处理 存入DB
		int reslut = mfrg005Service.insert(paramEntity);
		if (reslut == 0) {
			return "对不起，绑定失败！";
		}
		// 绑定成功
		return "";
	}

	/**
	 * 解除就诊卡绑定处理。
	 * 
	 * @param mpst005Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "unbind", method = RequestMethod.POST)
	@ResponseBody
	public String unbind(@ModelAttribute Mpst005Form mpst005Form) {
		HospitalCardInfoEntity paramEntity = new HospitalCardInfoEntity();
		paramEntity.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		paramEntity.setJiuzhenkahao(mpst005Form.getPatCardNo());
		paramEntity.setInsertTimeStamp(new Timestamp(System.currentTimeMillis()));

		HospitalCardInfoEntity entity = mfrg005Service.getCardByPrimaryKey(paramEntity);
		if (entity == null) {
			return "该就诊卡未被绑定，操作无效!";
		}
		// 业务处理 存入DB
		int reslut = mfrg005Service.deleteByPrimaryKey(paramEntity);
		if (reslut == 0) {
			return "对不起，解除绑定失败！";
		}
		// 绑定成功
		return "";
	}

	/**
	 * 发送验证码到手机。
	 * 
	 * @param mpst005Form
	 *            画面From
	 * @return 验证码
	 */
	@RequestMapping(value = "codeFetch", method = RequestMethod.POST)
	@ResponseBody
	public String codeFetch(@ModelAttribute Mpst005Form mpst005Form) {
		// 业务处理
		// 返回结果
		return (int) (Math.random() * 9000 + 1000) + ""; // 4位随机数
	}

}
