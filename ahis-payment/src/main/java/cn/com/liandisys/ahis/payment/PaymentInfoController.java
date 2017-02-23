package cn.com.liandisys.ahis.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentInfoController {

	@RequestMapping("/info")
	@ResponseBody
	public String info() {
		return "Ahis Payment.";
	}
}
