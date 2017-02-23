package cn.com.liandisys.ahis.webapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.webapp.entity.RegisterRelateEntity;
import cn.com.liandisys.ahis.webapp.form.Mfrg005Form;
import cn.com.liandisys.ahis.webapp.service.Mfrg005Service;

@Controller
@RequestMapping("m/mfrg005/*")
public class Mfrg005Controller extends AbstractAhisController<Mfrg005Form> {
	@Autowired
	private Mfrg005Service mfrg005Service;

	@Value("${payment.sltf.mock.confirm.url}")
	private String confirmMockUrl;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfrg005Form mfrg005Form, HttpServletRequest req) {
		RegisterRelateEntity response = mfrg005Service.getRegisterInfo(mfrg005Form.getPsOrdNum());
		mfrg005Form.setDeptName(response.getDoctorBasicInfoEntity().getDepartmentName());
		mfrg005Form.setDoctorName(response.getDoctorBasicInfoEntity().getDoctorName());
		mfrg005Form.setScheduleDate(convDateToString(response.getRegisterHistoryEntity().getHappenDate()));
		mfrg005Form.setTimeFlag(response.getRegisterHistoryEntity().getHappenPeriod());
		mfrg005Form.setPayAmt(String.valueOf(response.getRegisterHistoryEntity().getRegisterFee()));
		mfrg005Form.setHisOrdNum(response.getRegisterHistoryEntity().getHisOrdNum());
		return forwardIndex();
	}

	@RequestMapping(value = "payNow", method = RequestMethod.POST)
	public RedirectView payNow(@ModelAttribute Mfrg005Form mfrg005Form) {
		PaymentRecordDto entity = mfrg005Service.getPaymentRecord(mfrg005Form);
		String paymentNo;
		if (null == entity) {
			paymentNo = mfrg005Service.insertPaymentRecord(mfrg005Form);
		} else {
			paymentNo = entity.getPaymentNo();
		}
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(confirmMockUrl);
		Map<String, String> att = new HashMap<>();
		att.put("paymentNo", paymentNo);
		redirectView.setAttributesMap(att);
		return redirectView;
	}

	private String convDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.format(date);
	}
}
