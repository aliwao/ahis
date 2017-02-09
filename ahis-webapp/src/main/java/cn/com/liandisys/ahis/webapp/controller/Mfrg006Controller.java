package cn.com.liandisys.ahis.webapp.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.liandisys.ahis.webapp.common.AbstractAhisController;
import cn.com.liandisys.ahis.webapp.form.Mfrg005Form;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.response.AppointPaymentResponse;
import cn.com.liandisys.ahis.webapp.service.Mfrg005Service;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("m/mfrg006/*")
public class Mfrg006Controller extends AbstractAhisController<Mfrg005Form> {
	@Autowired
	private Mfrg005Service mfrg005Service;

	@RequestMapping("index")
	public String index(@ModelAttribute Mfrg005Form mfrg005Form, HttpServletRequest req) {
		return forwardIndex();
	}

	@ResponseBody
	@RequestMapping(value = "updateStatus", method = RequestMethod.POST)
	public String updateStatus(@ModelAttribute Mfrg005Form mfrg005Form) {
		// TODO 支付预约订单，缴费系统返回
		String agtOrdNum = "2017020813390001";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String payTime = simpleDateFormat.format(new Date());
		JSONObject requestJson = new JSONObject();
		requestJson.put("hisOrdNum", mfrg005Form.getHisOrdNum());
		requestJson.put("psOrdNum", mfrg005Form.getPsOrdNum());
		requestJson.put("payMode", mfrg005Form.getPayMode());
		requestJson.put("payAmt", mfrg005Form.getPayAmt());
		requestJson.put("agtOrdNum", agtOrdNum);
		requestJson.put("payTime", payTime);
		JSONObject responeJson;
		try {
			responeJson = HisHttpJson.executeHisApi("appointPayment", requestJson);
			AppointPaymentResponse respone = HisHttpJson.convJsonToBean(responeJson, AppointPaymentResponse.class);
			if (respone.getResultCode().equals("0")) {
				mfrg005Service.updateStatus(mfrg005Form, "3");
			} else {
				return "error";
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
