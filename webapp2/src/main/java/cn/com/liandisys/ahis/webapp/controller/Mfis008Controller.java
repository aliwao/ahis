package cn.com.liandisys.ahis.webapp.controller;

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

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfis008Form;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.item.HospitalizationBaseItem;
import cn.com.liandisys.ahis.webapp.service.HospitalizationService;
import cn.com.liandisys.ahis.webapp.utils.AhisCommonUtil;
import cn.com.liandisys.ahis.webapp.utils.MakeOrdNumUtil;

/**
 * 押金补缴页面控制器。
 * 
 * @author xuyue
 * @version 1.0
 */
@Controller
@RequestMapping("m/mfis008/*")
public class Mfis008Controller extends AbstractAhisController<Mfis008Form> {

	@Autowired
	private HospitalizationService hospitalizationService;

	@Autowired
	private HospitalizationService mfis008ervice;

	@Value("${payment.sltf.mock.confirm.url}")
	private String confirmMockUrl;

	/** 状态Flag 1:在院 */
	private static String HOSPITAL_STAY = "1";

	@RequestMapping("index")
	public String index(@ModelAttribute Mfis008Form mfis008Form, HttpServletRequest req) {
		mfis008Form.setUserName(AhisCommonUtil.getCurrentUserInfo().getFullName());
		return forwardIndex();
	}

	@RequestMapping(value = "pay", method = RequestMethod.POST)
	public RedirectView pay(@ModelAttribute Mfis008Form mfis008Form, HttpServletRequest req, RedirectAttributes attr) {
		HospitalizationBaseHisRequest request = new HospitalizationBaseHisRequest();
		request.setPatCardType("1");
		request.setPatCardNo("1234567");
		List<HospitalizationBaseItem> itemList = hospitalizationService.getWx3yHospitalizationRecord(request);

		HospitalizationBaseItem stayItem = null;
		for (int i = 0, len = itemList.size(); i < len; i++) {
			HospitalizationBaseItem item = itemList.get(i);
			if (HOSPITAL_STAY.equals(item.getStatus())) {
				stayItem = item;
			}
		}

		String paymentNo = MakeOrdNumUtil.create(2);
		hospitalizationService.insertPaymentRecord(paymentNo, mfis008Form.getPayFee(), stayItem);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(confirmMockUrl);
		Map<String, String> att = new HashMap<>();
		att.put("paymentNo", paymentNo);
		redirectView.setAttributesMap(att);
		return redirectView;
	}

}
