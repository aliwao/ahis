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
import cn.com.liandisys.ahis.webapp.entity.MedicareCardInfoEntity;
import cn.com.liandisys.ahis.webapp.form.Mpst004Form;
import cn.com.liandisys.ahis.webapp.service.Mpst004Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 医保卡绑定页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mpst004/*")
public class Mpst004Controller extends AbstractAhisController<Mpst004Form> {

	@Autowired
	private Mpst004Service mfrg004Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mpst004Form mpst004Form, HttpServletRequest req) {
		String cardNo = mfrg004Service.getCardByUserId(AhisCommonUtil.getCurrentUserInfo().getUserID());
		if (StringUtils.isNotEmpty(cardNo)) {
			mpst004Form.setPatCardNo(cardNo);
			mpst004Form.setExistCard("1");
		}
		return forwardIndex();
	}

	/**
	 * 医保卡绑定处理。
	 * 
	 * @param mpst004Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "bind", method = RequestMethod.POST)
	@ResponseBody
	public String bind(@ModelAttribute Mpst004Form mpst004Form) {

		MedicareCardInfoEntity paramEntity = new MedicareCardInfoEntity();
		paramEntity.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		paramEntity.setYibaokahao(mpst004Form.getPatCardNo());
		paramEntity.setInsertTimeStamp(new Timestamp(System.currentTimeMillis()));

		MedicareCardInfoEntity entity = mfrg004Service.getCardByPrimaryKey(paramEntity);
		if (entity != null) {
			return "该医保卡已被绑定，不可再次绑定!";
		}
		// 业务处理 存入DB
		int reslut = mfrg004Service.insert(paramEntity);
		if (reslut == 0) {
			return "对不起，绑定失败！";
		}
		// 绑定成功
		return "";
	}

	/**
	 * 解除医保卡绑定处理。
	 * 
	 * @param mpst004Form
	 *            画面From
	 * @return 处理结果
	 */
	@RequestMapping(value = "unbind", method = RequestMethod.POST)
	@ResponseBody
	public String unbind(@ModelAttribute Mpst004Form mpst004Form) {

		MedicareCardInfoEntity paramEntity = new MedicareCardInfoEntity();
		paramEntity.setUserId(new Long(AhisCommonUtil.getCurrentUserInfo().getUserID()));
		paramEntity.setYibaokahao(mpst004Form.getPatCardNo());
		paramEntity.setInsertTimeStamp(new Timestamp(System.currentTimeMillis()));

		MedicareCardInfoEntity entity = mfrg004Service.getCardByPrimaryKey(paramEntity);
		if (entity == null) {
			return "该医保卡未被绑定，操作无效!";
		}
		// 业务处理 存入DB
		int reslut = mfrg004Service.deleteByPrimaryKey(paramEntity);
		if (reslut == 0) {
			return "对不起，解除绑定失败！";
		}
		// 绑定成功
		return "";
	}

	/**
	 * 发送验证码到手机。
	 * 
	 * @param mpst004Form
	 *            画面From
	 * @return 验证码
	 */
	@RequestMapping(value = "codeFetch", method = RequestMethod.POST)
	@ResponseBody
	public String codeFetch(@ModelAttribute Mpst004Form mpst004Form) {
		// 业务处理
		// 返回结果
		return (int) (Math.random() * 9000 + 1000) + ""; // 4位随机数
	}

}
