package cn.com.liandisys.ahis.wx3h.controller;

import javax.xml.bind.JAXBException;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.liandisys.ahis.wx3h.component.HisJsonApiClient;
import cn.com.liandisys.ahis.wx3h.entity.request.AppointPaymentRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.AppointmentRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.BaseRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.CreatPatientInfoRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.DoctorInfoRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.HospitalDeptRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.HospitalizationFeeRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.HospitalizationRecordRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.InspReportDetailSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.InspReportListSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.InspResultDetailSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.InspResultListSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.PayDetailSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.PayRecordSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.PhyExamItemDetailSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.PhyExamReportDetailSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.PhyExamReportListSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.RegRecordSereachRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.RegisterInfoRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.RegisterPaymentNoticeRequest;
import cn.com.liandisys.ahis.wx3h.entity.request.DepositPayNoticeRequest;
import cn.com.liandisys.ahis.wx3h.utils.AESUtil;

@RestController
@RequestMapping("wx3h/his/*")
public class Wx3hApiController {

	private static final Logger logger = LoggerFactory.getLogger(Wx3hApiController.class);

	@Autowired
	private HisJsonApiClient hisJsonApi;

	/**
	 * 首诊患者建档。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 诊疗卡信息
	 */
	@RequestMapping(value = "CreatPatientInfo", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String creatPatientInfo(@RequestBody String requestJson) {
		CreatPatientInfoRequest reqEntity = convertJsonToBean(CreatPatientInfoRequest.class, requestJson);
		return returnHisJson("CreatPatientInfo", reqEntity);
	}
	
	/**
	 * 科室信息查询
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 医院科室列表信息
	 */
	@RequestMapping(value = "QueryDeptInfo", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getHostipalDept(@RequestBody String requestJson) {
		HospitalDeptRequest reqEntity = convertJsonToBean(HospitalDeptRequest.class, requestJson);
		return returnHisJson("QueryDeptInfo", reqEntity);
	}

	/**
	 * 科室信息查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 科室信息
	 */
	@RequestMapping(value = "dept-info", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getDeptInfo(@RequestBody String requestJson) {
		HospitalDeptRequest reqEntity = convertJsonToBean(HospitalDeptRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("deptCode:" + reqEntity.getDeptCode());
		return returnHisJson("dept-info", reqEntity);
	}

	/**
	 * 预约号源信息查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约号源信息
	 */
	@RequestMapping(value = "QueryYRegisterSource", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getRegisterInfo(@RequestBody String requestJson) {
		RegisterInfoRequest reqEntity = convertJsonToBean(RegisterInfoRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("deptCode:" + reqEntity.getDeptCode());
		logger.info("doctorCode:" + reqEntity.getDoctorCode());
		return returnHisJson("QueryYRegisterSource", reqEntity);
	}

	/**
	 * 医生信息查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 医生信息
	 */
	@RequestMapping(value = "QueryDoctInfo", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getDoctorInfo(@RequestBody String requestJson) {
		DoctorInfoRequest reqEntity = convertJsonToBean(DoctorInfoRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("deptCode:");
		logger.info("doctorCode:");
		return returnHisJson("QueryDoctInfo", reqEntity);
	}
	
	/**
	 * 预约挂号。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约挂号
	 */
	@RequestMapping(value = "Lock_YYRegister", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String appointment(@RequestBody String requestJson) {
		AppointmentRequest reqEntity = convertJsonToBean(AppointmentRequest.class, requestJson);
		logger.info("psOrdNum:");
		return returnHisJson("Lock_YYRegister", reqEntity);
	}
	
	/**
	 * 预约支付。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约支付
	 */
	@RequestMapping(value = "Pay_YYRegister", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String appointPayment(@RequestBody String requestJson) {
		AppointPaymentRequest reqEntity = convertJsonToBean(AppointPaymentRequest.class, requestJson);
		logger.info("psOrdNum:");
		return returnHisJson("Pay_YYRegister", reqEntity);
	}
	
	/**
	 * 取消预约。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 取消预约
	 */
	@RequestMapping(value = "UnLock_YYRegeister", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String cancelAppointment(@RequestBody String requestJson) {
		AppointPaymentRequest reqEntity = convertJsonToBean(AppointPaymentRequest.class, requestJson);
		logger.info("psOrdNum:");
		return returnHisJson("UnLock_YYRegeister", reqEntity);
	}
	
	/**
	 * 预约挂号记录查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约挂号记录
	 */
	@RequestMapping(value = "Query_YRegisterRecord", method = {RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getRegRecordSereach(@RequestBody String requestJson) {
		RegRecordSereachRequest reqEntity = convertJsonToBean(RegRecordSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("hisOrdNum:");
		logger.info("patCardNo:");
		logger.info("patCardType:");

		return returnHisJson("Query_YRegisterRecord", reqEntity);
	}

	/**
	 * 门诊待缴费记录查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 门诊待缴费记录
	 */
	@RequestMapping(value = "MZDJFJLCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getPayRecordSereach(@RequestBody String requestJson) {
		PayRecordSereachRequest reqEntity = convertJsonToBean(PayRecordSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardNo:");
		logger.info("patCardType:");

		return returnHisJson("MZDJFJLCX", reqEntity);
	}

	/**
	 * 缴费明细查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 缴费明细
	 */
	@RequestMapping(value = "MZDJFJLMXCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getPayDetailSereach(@RequestBody String requestJson) {
		PayDetailSereachRequest reqEntity = convertJsonToBean(PayDetailSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("hisOrdNum:");
		logger.info("patCardNo:");
		logger.info("patCardType:");
		return returnHisJson("MZDJFJLMXCX", reqEntity);
	}
	
	/**
	 * 检查结果列表查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 检查结果列表
	 */
	@RequestMapping(value = "JCJGLBCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getInspResultListSereach(@RequestBody String requestJson) {
		InspResultListSereachRequest reqEntity = convertJsonToBean(InspResultListSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardNo:");
		logger.info("patCardType:");
		logger.info("beginDate:");
		logger.info("endDate:");
		return returnHisJson("JCJGLBCX", reqEntity);
	}
	
	/**
	 * 检验报告列表查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 检验报告列表
	 */
	@RequestMapping(value = "JYBGLBCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getInspReportListSereach(@RequestBody String requestJson) {
		InspReportListSereachRequest reqEntity = convertJsonToBean(InspReportListSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardNo:");
		logger.info("patCardType:");
		logger.info("beginDate:");
		logger.info("endDate:");
		return returnHisJson("JYBGLBCX", reqEntity);
	}
	
	/**
	 * 体检报告列表查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 体检报告列表
	 */
	@RequestMapping(value = "TJBGLBCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getPhyExamReportListSereach(@RequestBody String requestJson) {
		PhyExamReportListSereachRequest reqEntity = convertJsonToBean(PhyExamReportListSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patName:");
		logger.info("patCardNo:");
		logger.info("beginDate:");
		logger.info("endDate:");
		return returnHisJson("TJBGLBCX", reqEntity);
	}
	
	/**
	 * 检查结果详情查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 检查结果详情
	 */
	@RequestMapping(value = "JCJGXQCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getInspResultDetailSereach(@RequestBody String requestJson) {
		InspResultDetailSereachRequest reqEntity = convertJsonToBean(InspResultDetailSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardType:");
		logger.info("patCardNo:");
		logger.info("checkId:");
		return returnHisJson("JCJGXQCX", reqEntity);
	}
	
	/**
	 * 检验报告详情查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 检验报告详情
	 */
	@RequestMapping(value = "JYBGXQCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getInspReportDetailSereach(@RequestBody String requestJson) {
		InspReportDetailSereachRequest reqEntity = convertJsonToBean(InspReportDetailSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardType:");
		logger.info("patCardNo:");
		logger.info("inspectId:");
		return returnHisJson("JYBGXQCX", reqEntity);
	}
	
	/**
	 * 检验报告详情查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 检验报告详情
	 */
	@RequestMapping(value = "TJBGXQCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getPhyExamReportDetailSereach(@RequestBody String requestJson) {
		PhyExamReportDetailSereachRequest reqEntity = convertJsonToBean(PhyExamReportDetailSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patName:");
		logger.info("patCardNo:");
		logger.info("phyExamId:");
		return returnHisJson("TJBGXQCX", reqEntity);
	}
	
	/**
	 * 体检项目详情查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 体检项目详情
	 */
	@RequestMapping(value = "TJXMXQCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getPhyExamItemDetailSereach(@RequestBody String requestJson) {
		PhyExamItemDetailSereachRequest reqEntity = convertJsonToBean(PhyExamItemDetailSereachRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patName:");
		logger.info("patCardNo:");
		logger.info("phyExamId:");
		logger.info("itemId:");
		return returnHisJson("TJXMXQCX", reqEntity);
	}

	/**
	 * 住院记录查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 住院记录
	 */
	@RequestMapping(value = "ZYJLCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getHospitalizationRecord(@RequestBody String requestJson) {
		HospitalizationRecordRequest reqEntity = convertJsonToBean(HospitalizationRecordRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardType:" + reqEntity.getPatCardType());
		logger.info("patCardNo:" + reqEntity.getPatCardNo());
		return returnHisJson("ZYJLCX", reqEntity);
	}

	/**
	 * 住院费用清单查询。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 住院费用清单
	 */
	@RequestMapping(value = "ZYFYQDCX", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String getHospitalizationFee(@RequestBody String requestJson) {
		HospitalizationFeeRequest reqEntity = convertJsonToBean(HospitalizationFeeRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardType:" + reqEntity.getPatCardType());
		logger.info("patCardNo:" + reqEntity.getPatCardNo());
		logger.info("admissionNum:" + reqEntity.getAdmissionNum());
		logger.info("beginDate:" + reqEntity.getBeginDate());
		logger.info("outDate:" + reqEntity.getEndDate());
		return returnHisJson("ZYFYQDCX", reqEntity);
	}

	/**
	 * 住院押金补缴支付结果通知。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 住院押金补缴支付结果
	 */
	@RequestMapping(value = "ZYYJBJZF", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String depositPayNotice(@RequestBody String requestJson) {
		DepositPayNoticeRequest reqEntity = convertJsonToBean(DepositPayNoticeRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("patCardType:" + reqEntity.getPatCardType());
		logger.info("patCardNo:" + reqEntity.getPatCardNo());
		logger.info("admissionNum:" + reqEntity.getAdmissionNum());
		logger.info("agtOrdNum:" + reqEntity.getAgtOrdNum());
		logger.info("payAmt:" + reqEntity.getPayAmt());
		return returnHisJson("ZYYJBJZF", reqEntity);
	}
	
	/**
	 * 门诊缴费通知。
	 * 
	 * @param requestJson
	 *            请求参数
	 * @return 预约结果
	 */
	@RequestMapping(value = "MZJFDDZF", method = { RequestMethod.POST }, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String clinicPaymentHisNotice(@RequestBody String requestJson) {
		RegisterPaymentNoticeRequest reqEntity = convertJsonToBean(RegisterPaymentNoticeRequest.class, requestJson);
		// 日志中输出相关信息
		logger.info("hisOrdNum:" + reqEntity.getHisOrdNum());
		logger.info("psOrdNum:" + reqEntity.getPsOrdNum());
		return returnHisJson("MZJFDDZF", reqEntity);
	}

	/**
	 * 请求医院His系统的数据（以JSON格式返回）
	 * 
	 * @param url
	 * @param requestJson
	 * @return His系统的JSON格式数据
	 */
	private <E extends BaseRequest> String returnHisJson(String hisurl, E paramsEntity) {
		JSONObject responeJson = hisJsonApi.executeHisApi("/his/" + hisurl, paramsEntity);
		if (responeJson != null) {
			logger.info(responeJson.toString());
		}
		else {
			responeJson = new JSONObject();
		}
		return AESUtil.encrypt(responeJson.toString());
	}

	/**
	 * 将String类型的xml转换成Request对象
	 * 
	 * @param clazz
	 * @param paramsJsonStr
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	private static <T extends BaseRequest> T convertJsonToBean(Class<?> clazz, String paramsJsonStr) {
		String deAseStr = AESUtil.decrypt(paramsJsonStr);
		JSONObject paramsJson = JSONObject.fromObject(deAseStr);
		return (T)JSONObject.toBean(paramsJson, clazz);
	}
}
