package cn.com.liandisys.ahis.mock.controller;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.liandisys.ahis.mock.form.payment.sltf.OrderPaymentCallBackForm;
import cn.com.liandisys.ahis.mock.form.payment.sltf.OrderPaymentForm;
import cn.com.liandisys.ahis.mock.form.payment.sltf.QueryForm;
import cn.com.liandisys.ahis.mock.form.payment.sltf.QueryResultForm;

@Controller
@RequestMapping("/mock/payment/sltf")
public class MockPaymentSltf {

    Logger logger = LoggerFactory.getLogger(MockPaymentSltf.class);

    @RequestMapping("/orderPayment.html")
    public ModelAndView orderPayment(@ModelAttribute OrderPaymentForm orderPaymentForm) {
        ModelAndView mav = new ModelAndView("payment_sltf_order_card_choose");
        orderPaymentForm.setOrderfee(orderPaymentForm.getOrderfee());
        orderPaymentForm.setPayfee(orderPaymentForm.getPayfee());
        mav.addObject("orderPaymentForm", orderPaymentForm);
        return mav;
    }

    @RequestMapping("/payment_sltf_order_confirm.html")
    public ModelAndView orderPaymentConfirm(@ModelAttribute OrderPaymentForm orderPaymentForm) {
        ModelAndView mav = new ModelAndView("payment_sltf_order_confirm");
        return mav;
    }

    @RequestMapping("/payment_sltf_order_success.html")
    public ModelAndView orderPaymentSuccess(@ModelAttribute OrderPaymentForm orderPaymentForm) {
        ModelAndView mav = new ModelAndView("payment_sltf_order_success");
        OrderPaymentCallBackForm orderPaymentCallBackForm = new OrderPaymentCallBackForm();
        orderPaymentCallBackForm.setVersion(orderPaymentForm.getVersion());
        orderPaymentCallBackForm.setCharset(orderPaymentForm.getCharset());
        orderPaymentCallBackForm.setSystemid(orderPaymentForm.getSystemid());
        orderPaymentCallBackForm.setMsgseqno(orderPaymentForm.getMsgseqno());
        orderPaymentCallBackForm.setUid(orderPaymentForm.getUid());
        orderPaymentCallBackForm.setOrderid(orderPaymentForm.getOrderid());
        orderPaymentCallBackForm.setOrderfee(orderPaymentForm.getOrderfee());
        orderPaymentCallBackForm.setCustominfo(orderPaymentForm.getCustominfo());
        orderPaymentCallBackForm.setReserved(orderPaymentForm.getReserved());
        // orderPaymentCallBackForm.setResultcode(orderPaymentForm.getResultcode());
        // orderPaymentCallBackForm.setResultmsg(orderPaymentForm.getResultmsg());
        orderPaymentCallBackForm.setSignmsg(orderPaymentForm.getSignmsg());
        mav.addObject("orderPaymentCallBackForm", orderPaymentCallBackForm);
        try {
            mav.addObject("postUrl", new String(Base64.decodeBase64(orderPaymentForm.getFronturl()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("/mQuery.html")
    @ResponseBody
    public QueryResultForm orderPaymentQuery(@ModelAttribute QueryForm queryForm) {
        QueryResultForm queryResultForm = new QueryResultForm();
        // 接口版本号 原样返回订单支付请求中的字段值
        queryResultForm.setVersion(queryForm.getVersion());
        // 字符集 原样返回订单支付请求中的字段值
        queryResultForm.setCharset(queryForm.getCharset());
        // 合作平台编号 原样返回订单支付请求中的字段值
        queryResultForm.setSystemid(queryForm.getSystemid());
        // 商户编号 原样返回订单支付请求中的字段值
        queryResultForm.setCorpid(queryForm.getCorpid());
        // 商户收费项目编号 原样返回订单支付请求中的字段值
        queryResultForm.setItemid(queryForm.getItemid());
        // 付费编号 原样返回订单支付请求中的字段值
        queryResultForm.setCorpuserid(queryForm.getCorpuserid());
        // 商户订单号 原样返回订单支付请求中的字段值
        queryResultForm.setOrderid(queryForm.getOrderid());
        // 商户订单金额 原样返回订单支付请求中的字段值
        queryResultForm.setOrderfee("");
        // 商户订单提交时间 原样返回订单支付请求中的值
        queryResultForm.setOrderdatetime(queryForm.getOrderdatetime());
        // 支付订单号 字符串，商联通付平台订单号，对账使用
        queryResultForm.setPayorderid("");
        // 订单实际支付金额 整形数字，以分为单位。例如:10元，金额应为1000
        queryResultForm.setPayfee("");
        // 手续费 整形数字，以分为单位。例如:10元，金额应为1000
        queryResultForm.setRatefee("");
        // 支付时间 数字串，共14位，格式为年月日时分秒，例如：20101208103015
        queryResultForm.setPaydatetime("");
        // 保留字段 字符串，原样返回订单支付请求中的值
        queryResultForm.setReserved(queryForm.getReserved());
        // 支付结果编码 请参见附录3
        queryResultForm.setPayresultcode("0000");
        // 支付结果描述 请参见附录3
        queryResultForm.setPayresultcode("支付成功。");
        // 签名字符串 Base64编码格式，验证signmsg方法请参见附录2
        queryResultForm.setSignmsg("");
        return queryResultForm;
    }
}
