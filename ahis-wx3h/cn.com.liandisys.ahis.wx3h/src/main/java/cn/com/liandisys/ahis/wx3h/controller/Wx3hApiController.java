package cn.com.liandisys.ahis.wx3h.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.liandisys.ahis.wx3h.component.HisJsonApiClient;
import cn.com.liandisys.ahis.wx3h.utils.AESUtil;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("wx3h/his/*")
public class Wx3hApiController {

	private static final Logger logger = LoggerFactory.getLogger(Wx3hApiController.class);

	@Autowired
	private HisJsonApiClient hisJsonApi;

	/**
	 * HIS共通接口(ASE加解密方式)
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 医院科室列表信息
	 */
	@RequestMapping(value = "ase/{pathname}", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String commonAseApi(@PathVariable("pathname")String pathname, @RequestBody String jsonstr) {
		String deAseStr = AESUtil.decrypt(jsonstr);
		JSONObject jsonrslt = returnHisJson(pathname, JSONObject.fromObject(deAseStr));
		return AESUtil.encrypt(jsonrslt.toString());
	}

	/**
	 * HIS共通接口
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 医院科室列表信息
	 */
	@RequestMapping(value = "noase/{pathname}", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject commonNoaseApi(@PathVariable("pathname")String pathname, @RequestBody JSONObject requestJson) {
		return returnHisJson(pathname, requestJson);
	}

	/**
	 * 医院科室列表信息查询
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 医院科室列表信息
	 */
	@RequestMapping(value = "hospital-dept", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getHostipalDept(@RequestBody JSONObject requestJson) {
		return returnHisJson("hospital-dept", requestJson);
	}

	/**
	 * 科室信息查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 科室信息
	 */
	@RequestMapping(value = "dept-info", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getDeptInfo(@RequestBody JSONObject requestJson) {
		// 日志中输出相关信息
		logger.info("deptCode:");
		return returnHisJson("dept-info", requestJson);
	}

	/**
	 * 预约号源信息查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约号源信息
	 */
	@RequestMapping(value = "register-info", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getRegisterInfo(@RequestBody JSONObject requestJson) {

		// 日志中输出相关信息
		logger.info("deptCode:");
		logger.info("doctorCode:");
		return returnHisJson("register-info", requestJson);
	}

	/**
	 * 医生信息查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 医生信息
	 */
	@RequestMapping(value = "doctor-info", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getDoctorInfo(@RequestBody JSONObject requestJson) {
		// 日志中输出相关信息
		logger.info("deptCode:");
		logger.info("doctorCode:");
		return returnHisJson("doctor-info", requestJson);
	}
	
	/**
	 * 预约挂号。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约挂号
	 */
	@RequestMapping(value = "appointment", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject appointment(@RequestBody JSONObject requestJson) {
		logger.info("psOrdNum:");

		return returnHisJson("appointment", requestJson);
	}
	/**
	 * 预约支付。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约支付
	 */
	@RequestMapping(value = "appointPayment", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject appointPayment(@RequestBody JSONObject requestJson) {
		logger.info("psOrdNum:");

		return returnHisJson("appointPayment", requestJson);
	}

	/**
	 * 预约挂号记录查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约挂号记录
	 */
	@RequestMapping(value = "regRecordSereach", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getRegRecordSereach(@RequestBody JSONObject requestJson) {

		// 日志中输出相关信息
		logger.info("hisOrdNum:");
		logger.info("patCardNo:");
		logger.info("patCardType:");

		return returnHisJson("regRecordSereach", requestJson);
	}

	/**
	 * 门诊待缴费记录查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 门诊待缴费记录
	 */
	@RequestMapping(value = "payRecordSereach", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getPayRecordSereach(@RequestBody JSONObject requestJson) {

		// 日志中输出相关信息
		logger.info("patCardNo:");
		logger.info("patCardType:");

		return returnHisJson("payRecordSereach", requestJson);
	}

	/**
	 * 缴费明细查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 缴费明细
	 */
	@RequestMapping(value = "payDetailSereach", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JSONObject getPayDetailSereach(@RequestBody JSONObject requestJson) {

		// 日志中输出相关信息
		logger.info("hisOrdNum:");
		logger.info("patCardNo:");
		logger.info("patCardType:");

		return returnHisJson("payDetailSereach", requestJson);
	}

	/**
	 * 请求医院His系统的数据（以JSON格式返回）
	 * 
	 * @param url
	 * @param requestJson
	 * @return His系统的JSON格式数据
	 */
	private JSONObject returnHisJson(String hisurl, JSONObject requestJson) {
		JSONObject responeJson = hisJsonApi.executeHisApi("/his/" + hisurl, requestJson);
		if (responeJson != null) {
			logger.info(responeJson.toString());
			return responeJson;
		}
		return new JSONObject();
	}
}
