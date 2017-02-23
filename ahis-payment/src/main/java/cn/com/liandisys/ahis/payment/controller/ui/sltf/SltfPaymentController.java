package cn.com.liandisys.ahis.payment.controller.ui.sltf;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.liandisys.ahis.payment.dto.PaymentDetailDto;
import cn.com.liandisys.ahis.payment.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.payment.form.sltf.BaseForm;
import cn.com.liandisys.ahis.payment.form.sltf.ConfirmForm;
import cn.com.liandisys.ahis.payment.form.sltf.OrderPaymentResultForm;
import cn.com.liandisys.ahis.payment.form.sltf.PaymentSettleForm;
import cn.com.liandisys.ahis.payment.form.sltf.QueryForm;
import cn.com.liandisys.ahis.payment.form.sltf.QueryResultForm;
import cn.com.liandisys.ahis.payment.service.SltfPaymentService;
import cn.com.liandisys.ahis.payment.util.SigUtils;
import cn.com.liandisys.common.http.AhisHttpClient;
import cn.com.liandisys.common.http.AhisHttpClientConfig;

@Controller
@RequestMapping("/payment/sltf")
public class SltfPaymentController {

    @Value("${payment.sltf.mockmode}")
    private String mockMode;
    @Value("${payment.sltf.success.front.url}")
    private String frontUrl;
    @Value("${payment.sltf.success.callback.url}")
    private String callbackUrl;
    @Value("${payment.sltf.payment.url}")
    private String paymentUrl;
    @Value("${payment.sltf.mock.payment.url}")
    private String paymentMockUrl;
    @Value("${payment.sltf.query.url}")
    private String queryUrl;
    @Value("${payment.sltf.mock.query.url}")
    private String queryMockUrl;
    @Value("${payment.sltf.settle.url}")
    private String settleUrl;
    @Value("${payment.sltf.mock.settle.url}")
    private String settleMockUrl;
	@Value("${payment.sltf.webapp.paynotice.url}")
	private String hisPayNoticekUrl;
	@Value("${payment.sltf.webapp.mfis.url}")
	private String webappMfisUrl;
	@Value("${payment.sltf.webapp.mfop.url}")
	private String webappMfopUrl;

    @Autowired
    SltfPaymentService service;

    private static final Logger logger = LoggerFactory.getLogger(SltfPaymentController.class);
	private static String 商联通付_01 = "01";
	private static String 未支付_00 = "00";

    @RequestMapping("/test")
    @ResponseBody
    public String orderPayment() throws IOException {
        paymentSettle();
        return "success.";
        // Resource resource = new
        // FileSystemResourceLoader().getResource("classpath:payment/sltf/Sltf.pfx");
        // File file = resource.getFile();
        // if (!file.exists()) {
        // return "not exists.";
        // }
        //
        // Reader reader = null;
        // try {
		// System.out.println("以字符为单位读取文件内容，一次读一个字节：");
		// // 一次读一个字符
        // reader = new InputStreamReader(new FileInputStream(file));
        // int tempchar;
        // while ((tempchar = reader.read()) != -1) {
		// // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
		// // 但如果这两个字符分开显示时，会换两次行。
		// // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
        // if (((char) tempchar) != '\r') {
        // System.out.print((char) tempchar);
        // }
        // }
        // reader.close();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        //
        // return new
        // String(Base64.decodeBase64("aHR0cDovLzE3Mi4xNi41MC4zMzo4MDgzL3BheW1lbnQvc2x0Zi9zdWNjZXNz"),"UTF-8");
    }

    @RequestMapping("/confirm")
    public ModelAndView confirm(String paymentNo) {
		// DB获取缴费信息
        PaymentRecordDto dto = service.getPaymentRecord(paymentNo);

		// TODO 商联提交表单信息设置
        ModelAndView mav = new ModelAndView("sltf/confirm");
        ConfirmForm confirmForm = new ConfirmForm();
        confirmForm.setVersion("v1.0");
        confirmForm.setCharset("1");
        confirmForm.setSystemid("88888888");
        confirmForm.setBusinesstype("01");
        confirmForm.setPaymentmode("1001");
        confirmForm.setCorpid("TEST");
        confirmForm.setItemid("80");
		// 消息流水号
        confirmForm.setMsgseqno("M" + formatDateTime(new Date(), FORMAT_YMDHMSF) + "001");
        confirmForm.setUid("pmsp." + dto.getLoginUser());
        confirmForm.setCorpuserid("2");
        confirmForm.setCorpusername("2");
        confirmForm.setOrderid(dto.getPaymentNo());
        BigDecimal fee = new BigDecimal(dto.getOrderFee()).multiply(new BigDecimal(100)).divide(new BigDecimal(1), 0,
                BigDecimal.ROUND_HALF_UP);
        confirmForm.setOrderfee(fee);
        confirmForm.setPayfee(fee);

		Date orderdatetime = new Date();
		confirmForm.setOrderdatetime(formatDateTime(orderdatetime, FORMAT_YMDHMS));
        confirmForm.setAccountNumber("");
        confirmForm.setCustomphone("");
        try {
            confirmForm.setFronturl(Base64.encodeBase64String(frontUrl.getBytes("UTF-8")));
            confirmForm.setReceiveurl(Base64.encodeBase64String(callbackUrl.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
			logger.error("Base64编码失败。", e);
        }
		confirmForm.setNote("微医平台");
        confirmForm.setCustominfo("");
        confirmForm.setReserved("");
        confirmForm.setSignmsg(getSignmsg(confirmForm));
		logger.debug("签名后字符串：" + confirmForm.getSignmsg());
        mav.addObject("confirmForm", confirmForm);
        mav.addObject("postUrl", "1".equals(mockMode) ? paymentMockUrl : paymentUrl);

		// 支付明细表登录
		PaymentDetailDto detailDto = setPaymentDetail(dto, orderdatetime);
		service.insertPaymentDetail(detailDto);

        return mav;
    }

    private String getSignmsg(ConfirmForm confirmForm) {
        StringBuilder sb = new StringBuilder();
        sb.append("version=");
        sb.append(confirmForm.getVersion());
        sb.append("&charset=");
        sb.append(confirmForm.getCharset());
        sb.append("&systemid=");
        sb.append(confirmForm.getSystemid());
        sb.append("&businesstype=");
        sb.append(confirmForm.getBusinesstype());
        sb.append("&paymentmode=");
        sb.append(confirmForm.getPaymentmode());
        sb.append("&corpid=");
        sb.append(confirmForm.getCorpid());
        sb.append("&itemid=");
        sb.append(confirmForm.getItemid());
        sb.append("&msgseqno=");
        sb.append(confirmForm.getMsgseqno());
        sb.append("&uid=");
        sb.append(confirmForm.getUid());
        sb.append("&corpuserid=");
        sb.append(confirmForm.getCorpuserid());
        sb.append("&corpusername=");
        sb.append(confirmForm.getCorpusername());
        sb.append("&orderid=");
        sb.append(confirmForm.getOrderid());
        sb.append("&orderfee=");
        sb.append(confirmForm.getOrderfee());
        sb.append("&payfee=");
        sb.append(confirmForm.getPayfee());
        sb.append("&orderdatetime=");
        sb.append(confirmForm.getOrderdatetime());
        sb.append("&accountNumber=");
        sb.append(confirmForm.getAccountNumber());
        sb.append("&customphone=");
        sb.append(confirmForm.getCustomphone());
        sb.append("&fronturl=");
        sb.append(confirmForm.getFronturl());
        sb.append("&receiveurl=");
        sb.append(confirmForm.getReceiveurl());
        sb.append("&note=");
        sb.append(confirmForm.getNote());
        sb.append("&custominfo=");
        sb.append(confirmForm.getCustominfo());
        sb.append("&reserved=");
        sb.append(confirmForm.getReserved());

		logger.debug("加密前字符串:" + sb.toString());
        return SigUtils.signMessageWithCert(SigUtils.cryptMD5(sb.toString()).toLowerCase(),
                "classpath:payment/sltf/Sltf.pfx", "12345678");
    }

    @RequestMapping("/result")
    public ModelAndView payResult(@ModelAttribute OrderPaymentResultForm orderPaymentResultForm) throws Exception {
		// TODO:商联签名校验
        if (!"1".equals(mockMode)) {
            if (verifySign(orderPaymentResultForm)) {
				logger.info("校验成功。");
            } else {
				logger.info("校验失败。");
				throw new Exception("支付前面校验失败，");
            }
        }

		// 根据订单取最新的信息
		String paymentNo = orderPaymentResultForm.getOrderid();
		PaymentDetailDto detailDto = service.getPaymentDetail(paymentNo);

		QueryResultForm queryResultForm = null;
		if ("0000".equals(orderPaymentResultForm.getResultcode())) {
			// 商联订单状态查询
			QueryForm queryForm = setQueryForm(orderPaymentResultForm, detailDto);
			queryResultForm = query(queryForm);
			
		}
		// 更新支付详细表 缴费表 
		service.updatePaymentDetail(detailDto, queryResultForm, orderPaymentResultForm);
		service.updatePaymentRecord(detailDto);
		
		if ("0000".equals(orderPaymentResultForm.getResultcode())) {
			// 支付成功 调用web侧HIS通知
			AhisHttpClientConfig config = new AhisHttpClientConfig();
			config.setUri(hisPayNoticekUrl);
			config.setAccept(MediaType.TEXT_HTML_VALUE);
			List<NameValuePair> params = new ArrayList<>();
			params.add(new BasicNameValuePair("paymentNo", detailDto.getPaymentNo()));
			try {
				String result = AhisHttpClient.executeApi(config, params);
				logger.debug("结果：" + result);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		ModelAndView mav;
		if ("0000".equals(orderPaymentResultForm.getResultcode())) {
			mav = new ModelAndView("sltf/success");
			mav.addObject("isPaid", "1");
		} else {
			mav = new ModelAndView("sltf/error");
			mav.addObject("isPaid", "2");
		}

        mav.addObject("orderPaymentResultForm", orderPaymentResultForm);
        
        String type = orderPaymentResultForm.getOrderid().substring(0, 1);
		mav.addObject("postUrl", type.equals("2") && !"0000".equals(orderPaymentResultForm.getResultcode()) ? webappMfisUrl : webappMfopUrl);
		mav.addObject("buttonTitle", type.equals("2") && !"0000".equals(orderPaymentResultForm.getResultcode()) ? "返回住院" : "查看缴费一览");
        return mav;
    }

    private boolean verifySign(OrderPaymentResultForm orderPaymentResultForm) {

        StringBuilder str = new StringBuilder();
        str.append("version=").append(orderPaymentResultForm.getVersion());
        str.append("&charset=").append(orderPaymentResultForm.getCharset());
        str.append("&systemid=").append(orderPaymentResultForm.getSystemid());
        str.append("&msgseqno=").append(orderPaymentResultForm.getMsgseqno());
        str.append("&uid=").append(orderPaymentResultForm.getUid());
        str.append("&orderid=").append(orderPaymentResultForm.getOrderid());
        str.append("&orderfee=").append(orderPaymentResultForm.getOrderfee());
        str.append("&custominfo=").append(orderPaymentResultForm.getCustominfo());
        str.append("&reserved=").append(orderPaymentResultForm.getReserved());
        str.append("&resultcode=").append(orderPaymentResultForm.getResultcode());
        str.append("&resultmsg=").append(orderPaymentResultForm.getResultmsg());
		logger.debug("支付结果验签：" + str.toString());
        boolean verifyResult = SigUtils.verifySignWithCert(SigUtils.cryptMD5(str.toString()).toLowerCase(),
                orderPaymentResultForm.getSignmsg(), "classpath:payment/sltf/TrustSltf.crt");
        return verifyResult;
    }

    @RequestMapping("/cancel")
    public ModelAndView cancel() {
        return null;
    }

    private static final String FORMAT_YMDHMS = "yyyyMMddHHmmss";
    private static final String FORMAT_YMDHMSF = "yyyyMMddHHmmssSSS";

    private static String formatDateTime(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

	private QueryResultForm query(QueryForm queryForm) throws UnsupportedEncodingException {

        StringBuilder sb = new StringBuilder();
        sb.append("version=").append(queryForm.getVersion());
        sb.append("&charset=").append(queryForm.getCharset());
        sb.append("&systemid=").append(queryForm.getSystemid());
        sb.append("&corpid=").append(queryForm.getCorpid());
        sb.append("&itemid=").append(queryForm.getItemid());
        sb.append("&msgseqno=").append(queryForm.getMsgseqno());
        sb.append("&corpuserid=").append(queryForm.getCorpuserid());
        sb.append("&corpusername=").append(queryForm.getCorpusername());
        sb.append("&orderid=").append(queryForm.getOrderid());
        sb.append("&orderdatetime=").append(queryForm.getOrderdatetime());
        sb.append("&reserved=").append(queryForm.getReserved());

		logger.debug("加密前字符串:" + sb.toString());
        String signmsg = SigUtils.signMessageWithCert(SigUtils.cryptMD5(sb.toString()).toLowerCase(),
                "classpath:payment/sltf/Sltf.pfx", "12345678");
		logger.debug("加密后字符串:" + signmsg);
        queryForm.setSignmsg(signmsg);

        AhisHttpClientConfig config = new AhisHttpClientConfig();
        config.setUri("1".equals(mockMode) ? queryMockUrl : queryUrl);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("version", queryForm.getVersion()));
        params.add(new BasicNameValuePair("charset", queryForm.getCharset()));
        params.add(new BasicNameValuePair("systemid", queryForm.getSystemid()));
        params.add(new BasicNameValuePair("corpid", queryForm.getCorpid()));
        params.add(new BasicNameValuePair("itemid", queryForm.getItemid()));
        params.add(new BasicNameValuePair("msgseqno", queryForm.getMsgseqno()));
        params.add(new BasicNameValuePair("corpuserid", queryForm.getCorpuserid()));
        params.add(new BasicNameValuePair("corpusername", queryForm.getCorpusername()));
        params.add(new BasicNameValuePair("orderid", queryForm.getOrderid()));
        params.add(new BasicNameValuePair("orderdatetime", queryForm.getOrderdatetime()));
        params.add(new BasicNameValuePair("reserved", queryForm.getReserved()));
        params.add(new BasicNameValuePair("signmsg", queryForm.getSignmsg()));
        String responseEntity = AhisHttpClient.executeApi(config, params);

        QueryResultForm form = (QueryResultForm) JSONObject.toBean(JSONObject.fromObject(responseEntity),
                QueryResultForm.class);

        StringBuilder str = new StringBuilder();
        str.append("version=").append(form.getVersion());
        str.append("&charset=").append(form.getCharset());
        str.append("&systemid=").append(form.getSystemid());
        str.append("&corpid=").append(form.getCorpid());
        str.append("&itemid=").append(form.getItemid());
        str.append("&corpuserid=").append(form.getCorpuserid());
        str.append("&orderid=").append(form.getOrderid());
        str.append("&orderfee=").append(form.getOrderfee());
        str.append("&orderdatetime=").append(form.getOrderdatetime());
        str.append("&payorderid=").append(form.getPayorderid());
        str.append("&payfee=").append(form.getPayfee());
        str.append("&ratefee=").append(form.getRatefee());
        str.append("&paydatetime=").append(form.getPaydatetime());
        str.append("&reserved=").append(form.getReserved());
        str.append("&payresultcode=").append(form.getPayresultcode());
        str.append("&payresultmsg=");
        if (form.getPayresultmsg() != null) {
            str.append(form.getPayresultmsg());
        }
		logger.debug("支付结果验签：" + str.toString());
        boolean verifyResult = SigUtils.verifySignWithCert(SigUtils.cryptMD5(str.toString()).toLowerCase(),
                form.getSignmsg().replaceAll(" ", "+"), "classpath:payment/sltf/TrustSltf.crt");

        if (!verifyResult) {
			logger.warn("验签失败。");
            return null;
        }
		logger.info("验签成功。");
        return form;
    }

    private void paymentSettle() throws UnsupportedEncodingException {
        PaymentSettleForm paymentSettleForm = new PaymentSettleForm();
        setCorpInfo(paymentSettleForm);
        paymentSettleForm.setSettledate("20170220");

        StringBuilder sb = new StringBuilder();
        sb.append("version=").append(paymentSettleForm.getVersion());
        sb.append("&charset=").append(paymentSettleForm.getCharset());
        sb.append("&systemid=").append(paymentSettleForm.getSystemid());
        sb.append("&settledate=").append(paymentSettleForm.getSettledate());

		logger.debug("加密前字符串:" + sb.toString());
        String signmsg = SigUtils.signMessageWithCert(SigUtils.cryptMD5(sb.toString()).toLowerCase(),
                "classpath:payment/sltf/Sltf.pfx", "12345678");
		logger.debug("加密后字符串:" + signmsg);
        paymentSettleForm.setSignmsg(signmsg);

        AhisHttpClientConfig config = new AhisHttpClientConfig();
        config.setUri("1".equals(mockMode) ? settleMockUrl : settleUrl);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("version", paymentSettleForm.getVersion()));
        params.add(new BasicNameValuePair("charset", paymentSettleForm.getCharset()));
        params.add(new BasicNameValuePair("systemid", paymentSettleForm.getSystemid()));
        params.add(new BasicNameValuePair("settledate", paymentSettleForm.getSettledate()));
        params.add(new BasicNameValuePair("signmsg", paymentSettleForm.getSignmsg()));
        String responseEntity = AhisHttpClient.executeApi(config, params);

        logger.info(responseEntity);
        int index = responseEntity.indexOf("\r\n\r\n");
        String plainstr = responseEntity.substring(0, index + 2);
        String sigmsg = responseEntity.substring(index + 4);

        boolean verifyResult = SigUtils.verifySignWithCert(SigUtils.cryptMD5(plainstr).toLowerCase(),
                sigmsg.replaceAll(" ", "+"), "classpath:payment/sltf/TrustSltf.crt");

        if (!verifyResult) {
			logger.warn("验签失败。");
            return;
        }
		logger.info("验签成功。");
    }

    private static void setCorpInfo(BaseForm form) {
        form.setVersion("v1.0");
        form.setCharset("1");
        form.setSystemid("88888888");
    }

	private PaymentDetailDto setPaymentDetail(PaymentRecordDto dto, Date orderdatetime) {
		Timestamp nowDateTime = new Timestamp(System.currentTimeMillis());

		PaymentDetailDto detailDto = new PaymentDetailDto();
		detailDto.setPaymentNo(dto.getPaymentNo());
		detailDto.setPaymentDetailNo(1L); // TODO: 明细SEQ
		detailDto.setOrderFee(dto.getOrderFee());
		detailDto.setPayFee(dto.getOrderFee());
		detailDto.setPayType(商联通付_01);
		detailDto.setOrderDatetime(Timestamp.valueOf(formatDateTime(orderdatetime, "yyyy-MM-dd HH:mm:ss")));
		detailDto.setPaymentStatus(未支付_00);
		detailDto.setLoginTime(nowDateTime);
		detailDto.setLoginUser(dto.getLoginUser());
		detailDto.setUpdateTime(nowDateTime);
		detailDto.setUpdateUser(dto.getUpdateUser());
		return detailDto;
	}

	private QueryForm setQueryForm(OrderPaymentResultForm orderPaymentResultForm, PaymentDetailDto dto) {
		QueryForm queryForm = new QueryForm();
		setCorpInfo(queryForm);
		queryForm.setCorpid("TEST");
		queryForm.setItemid("80");
		queryForm.setMsgseqno("M" + formatDateTime(new Date(), FORMAT_YMDHMSF) + "001");
		queryForm.setCorpuserid("2");
		queryForm.setCorpusername("2");
		queryForm.setOrderid(orderPaymentResultForm.getOrderid());
		Date orderDate = dto.getOrderDatetime();
		queryForm.setOrderdatetime(formatDateTime(orderDate,FORMAT_YMDHMS));
		queryForm.setReserved("");
		return queryForm;
	}
}
