package cn.com.liandisys.ahis.webapp.component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.com.liandisys.common.http.AhisHttpClient;
import cn.com.liandisys.common.http.AhisHttpClientConfig;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

/**
 * 美圣短信接口组件
 *
 */
@Component
public class SendSmsComponent {

	/** logger */
	private static final Logger logger = LoggerFactory.getLogger(SendSmsComponent.class);

	/** 短信类型： 2-模板短信  */
	private static final String MSGTYPE = "2";

	/** 编码格式  */
	private static final String ENCODE = "gbk";

	/** 请求地址 */
	@Value("${sms.send.url}")
	private String url;

	/** 用户账号 */
	@Value("${sms.send.username}")
	private String username;

	/** 用户密码 */
	@Value("${sms.send.password}")
	private String password;

	/** 通信认证密码 */
	@Value("${sms.send.veryCode}")
	private String veryCode;

	/** 模板短信编号 */
	@Value("${sms.send.tempid}")
	private String tempid;

	public boolean sendSmsCode(String mobile, String vCode) {
		// 您本次的验证码是${no}，注意妥善保管，请勿泄漏。
		return sendSms(mobile, this.concat("@1@=", vCode));
	}

	public boolean sendSms(String mobile, String paramStr) {
		boolean isSendSuccess = false;

//		String url = "http://112.74.76.186:8030/service/httpService/httpInterface.do?method=sendMsg";
//		String username = "JSM40034";
//		String password = "40034";
//		String veryCode = "5xvcgdv5g0bm";
//		String tempid = "JSM40034-0021";

		AhisHttpClientConfig config = new AhisHttpClientConfig();
		config.setUri(url);
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair("password", password));
		params.add(new BasicNameValuePair("veryCode", veryCode));
		params.add(new BasicNameValuePair("msgtype", MSGTYPE));
		params.add(new BasicNameValuePair("tempid", tempid));
		params.add(new BasicNameValuePair("code", ENCODE));
		params.add(new BasicNameValuePair("mobile", mobile));
		params.add(new BasicNameValuePair("content", paramStr));
		try {
			String xmlStr = AhisHttpClient.executeApi(config, params);
			// 转化
			if(xmlStr != null && !"".equals(xmlStr)){
				JSONObject mtjson= (JSONObject)new XMLSerializer().read(xmlStr);
				JSONObject json = (JSONObject)mtjson.get("mt");
				String status = json.getString("status");
				//String msgid = json.getString("msgid");
				if("0".equals(status)) {
					isSendSuccess = true;
				}
			}
			//System.out.println(xmlStr);
			logger.debug(xmlStr);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return isSendSuccess;
	}

	private String concat(Object... objects) {
		if (objects == null) {
			return null;
		}
		StringBuilder b = new StringBuilder();
		for (Object o : objects) {
			b.append(o);
		}
		return b.toString();
	}
}
