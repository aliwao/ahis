package cn.com.liandisys.ahis.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfis009Form;
import cn.com.liandisys.ahis.webapp.his.entity.response.HospitalizationRecordItem;
import cn.com.liandisys.ahis.webapp.service.Mfis008Service;
import cn.com.liandisys.ahis.webapp.service.Mfis009Service;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;
import cn.com.liandisys.ahis.webapp.utils.MakeOrdNumUtil;

/**
 * 押金补缴页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfis009/*")
public class Mfis009Controller extends AbstractAhisController<Mfis009Form> {

	@Autowired
	Mfis009Service mfis009Service;

	@Autowired
	private Mfis008Service mfis008ervice;

	@Value("${payment.sltf.mock.confirm.url}")
	private String confirmMockUrl;

	/** 状态Flag 1:在院 */
	private static String HOSPITAL_STAY = "1";

	@RequestMapping("index")
	public String index(@ModelAttribute Mfis009Form mfis009Form, HttpServletRequest req) {
		mfis009Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getFullName());
		return forwardIndex();
	}

	@RequestMapping(value = "pay", method = RequestMethod.POST)
	public RedirectView pay(@ModelAttribute Mfis009Form mfis009Form, HttpServletRequest req, RedirectAttributes attr) {
		JSONObject json = new JSONObject();
		json.put("patCardType", "1");
		json.put("patCardNo", "1234567");
		List<HospitalizationRecordItem> itemList = new ArrayList<>();

			itemList = mfis008ervice.getWx3yHospitalizationRecord(json);


		HospitalizationRecordItem stayItem = null;
		for (int i = 0, len = itemList.size(); i < len; i++) {
			HospitalizationRecordItem item = itemList.get(i);
			if (HOSPITAL_STAY.equals(item.getStatus())) {
				stayItem = item;
			}
		}

		String paymentNo = MakeOrdNumUtil.create(2);
		mfis009Service.insertPaymentRecord(paymentNo, mfis009Form.getPayFee(), stayItem);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(confirmMockUrl);
		Map<String, String> att = new HashMap<>();
		att.put("paymentNo", paymentNo);
		redirectView.setAttributesMap(att);
		return redirectView;
	}

}
