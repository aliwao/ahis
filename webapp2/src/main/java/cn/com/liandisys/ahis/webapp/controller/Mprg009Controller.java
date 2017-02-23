package cn.com.liandisys.ahis.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.LoginUserInfo;
import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.entity.RegRecordEntity;
import cn.com.liandisys.ahis.webapp.form.Mprg009Form;
import cn.com.liandisys.ahis.webapp.service.Mprg009Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;

/**
 * 我的挂号页面控制器
 * 
 * @author liandi
 * @version 1.0
 *
 */
@Controller
@RequestMapping("m/mprg009/*")
public class Mprg009Controller extends AbstractAhisController<Mprg009Form> {

	@Autowired
	private Mprg009Service mprg009Service;

	@Value("${payment.sltf.mock.confirm.url}")
	private String confirmMockUrl;

	@RequestMapping("index")
	public String index(@ModelAttribute Mprg009Form mprg009Form, HttpServletRequest req) {
		LoginUserInfo loginUserInfo = AhisCommonUtil.getCurrentUserInfo();
		String type = null == mprg009Form.getType() ? "0" : mprg009Form.getType();
		List<RegRecordEntity> items = mprg009Service.searchRegRecord(loginUserInfo, type);
		mprg009Form.setItems(items);
		mprg009Form.setUserName(loginUserInfo.getFullName());
		mprg009Form.setType(type);
		return forwardIndex();
	}

	@RequestMapping(value = "cancelAppointment", method = RequestMethod.POST)
	@ResponseBody
	public String cancelAppointment(@RequestParam("hisOrdNum") String hisOrdNum,
			@RequestParam("psOrdNum") String psOrdNum, @RequestParam("cancelReason") String cancelReason) {
		if ("reason1".equals(cancelReason)) {
			cancelReason = "订单填写错误";
		}
		if ("reason2".equals(cancelReason)) {
			cancelReason = "预约时间不合理";
		}
		return mprg009Service.cancelAppointment(hisOrdNum, psOrdNum, cancelReason);
	}

	@RequestMapping(value = "payAppointment", method = RequestMethod.POST)
	@ResponseBody
	public String payNow(@ModelAttribute Mprg009Form mprg009Form) {
		PaymentRecordDto entity = mprg009Service.getPaymentRecord(mprg009Form);
		String paymentNo;
		if (null == entity) {
			paymentNo = mprg009Service.insertPaymentRecord(mprg009Form);
		} else {
			paymentNo = entity.getPaymentNo();
		}
		if (null == paymentNo) {
			return "error";
		}
		return confirmMockUrl + "?paymentNo=" + paymentNo;
	}
}
