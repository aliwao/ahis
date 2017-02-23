package cn.com.liandisys.ahis.payment.controller.notify.sltf;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/payment/sltf/notify")
public class NotifyController {

    @RequestMapping("/result")
    @ResponseBody
    public String orderPaymentResult() throws IOException {
        return "success";
    }
}
