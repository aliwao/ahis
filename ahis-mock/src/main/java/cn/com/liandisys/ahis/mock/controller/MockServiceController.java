package cn.com.liandisys.ahis.mock.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.liandisys.ahis.mock.entity.BaseRequest;
import cn.com.liandisys.ahis.mock.entity.BaseResponse;
import cn.com.liandisys.ahis.mock.entity.request.AppointPaymentRequest;
import cn.com.liandisys.ahis.mock.entity.request.AppointmentCancelRequest;
import cn.com.liandisys.ahis.mock.entity.request.AppointmentRequest;
import cn.com.liandisys.ahis.mock.entity.request.ClinicPayNoticeRequest;
import cn.com.liandisys.ahis.mock.entity.request.CreatPatientInfoRequest;
import cn.com.liandisys.ahis.mock.entity.request.DepositPayNoticeRequest;
import cn.com.liandisys.ahis.mock.entity.request.DoctorInfoRequest;
import cn.com.liandisys.ahis.mock.entity.request.HospitalDeptRequest;
import cn.com.liandisys.ahis.mock.entity.request.HospitalizationFeeRequest;
import cn.com.liandisys.ahis.mock.entity.request.HospitalizationRecordRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspReportDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspReportListSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspResultDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspResultListSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PayDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PayRecordSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PhyExamItemDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PhyExamReportDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PhyExamReportListSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.RegRecordSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.RegisterInfoRequest;
import cn.com.liandisys.ahis.mock.entity.response.HospitalDeptResponse;

@RestController
@RequestMapping("/mock")
public class MockServiceController {

	private static final Logger logger = LoggerFactory.getLogger(MockServiceController.class);

	/**
	 * 首诊患者建档。
	 * 
	 * @param String
	 *            requestParams
	 * @return 科室信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/CreatPatientInfo", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String creatPatientInfo(@RequestBody String requestParams) throws JAXBException, IOException {

		CreatPatientInfoRequest requestBody = (CreatPatientInfoRequest) preRequest(requestParams,
				CreatPatientInfoRequest.class);

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatIdNo());

		String xmlPath = "classpath:hisResult/CreatPatientInfo.xml";
		return readToString(xmlPath);
	}

	/**
	 * 科室信息查询。
	 * 
	 * @param String
	 *            requestParams
	 * @return 科室信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/QueryDeptInfo", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getHostipalDept(@RequestBody String requestParams) throws JAXBException, IOException {

		HospitalDeptRequest requestBody = (HospitalDeptRequest) preRequest(requestParams, HospitalDeptRequest.class);

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());

		String xmlPath = "classpath:hisResult/hospital-dept-response.xml";

		// 根据业务楼继需求，返回不同内容的xml
		if (requestBody.getDeptCode() != null && !"".equals(requestBody.getDeptCode())) {
			xmlPath = "classpath:hisResult/hospital-dept-" + requestBody.getDeptCode() + "-response.xml";
		}

		return readToString(xmlPath);
	}

	/**
	 * 预约号源信息查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 预约号源信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/QueryYRegisterSource", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getRegisterInfo(@RequestBody String requestParams) throws JAXBException, IOException {

		RegisterInfoRequest requestBody = (RegisterInfoRequest) preRequest(requestParams, RegisterInfoRequest.class);

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());
		String xmlPath;
		if (requestBody.getDoctorCode() == null || requestBody.getDoctorCode().isEmpty()) {
			xmlPath = "classpath:hisResult/dept-register-info/register-info-dept" + requestBody.getDeptCode() + "-response.xml";
		} else {
			logger.info("doctorCode:" + requestBody.getDoctorCode());
			xmlPath = "classpath:hisResult/register-info/register-info-personal" + requestBody.getDoctorCode() + "-response.xml";
		}

		return readToString(xmlPath);
	}

	/**
	 * 科室信息查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 预约号源信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/dept-info", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public HospitalDeptResponse getDeptInfo(@RequestBody HospitalDeptRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());
		String xmlPath = "classpath:hisResult/dept-info/dept-info-dept" + requestBody.getDeptCode() + "-response.xml";
		return getResponseFromXml(HospitalDeptResponse.class, xmlPath);
	}

	/**
	 * 医生信息查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 医生信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/QueryDoctInfo", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getDoctorInfo(@RequestBody String requestParams) throws JAXBException, IOException {

		DoctorInfoRequest requestBody = (DoctorInfoRequest) preRequest(requestParams, DoctorInfoRequest.class);

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());
		String xmlPath;
		if ((requestBody.getDeptCode() == null || requestBody.getDeptCode().isEmpty())
				&& (requestBody.getDoctorCode() == null || requestBody.getDoctorCode().isEmpty())) { // 获取无锡三院
																										// 所有的医生
			xmlPath = "classpath:hisResult/doctor-info/doctor-info-response.xml";

		} else if ((requestBody.getDeptCode() != null && !requestBody.getDeptCode().isEmpty())
				&& (requestBody.getDoctorCode() == null || requestBody.getDoctorCode().isEmpty())) { // 获取无锡三院
																										// 某科室的所有医生
			xmlPath = "classpath:hisResult/dept-doctor-info/doctor-info-dept" + requestBody.getDeptCode() + "-response.xml";

		} else {
			logger.info("doctorCode:" + requestBody.getDoctorCode()); // 获取无锡三院
																		// 某科室的某医生
			xmlPath = "classpath:hisResult/doctor-info/doctor-info-personal" + requestBody.getDoctorCode() + "-response.xml";
		}

		return readToString(xmlPath);
	}

	/**
	 * 预约挂号。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 预约挂号
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/Lock_YYRegister", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getRegRecordSereach(@RequestBody String requestParams) throws JAXBException, IOException {
		AppointmentRequest requestBody = (AppointmentRequest) preRequest(requestParams, AppointmentRequest.class);
		logger.info("psOrdNum:" + requestBody.getPsOrdNum());
		// logger.info("deptCode:" + requestBody.getPatCardNo());
		// logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "classpath:hisResult/appointment-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 预约挂号记录查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 预约挂号记录
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/Query_YRegisterRecord", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getRegReordSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		RegRecordSereachRequest requestBody = (RegRecordSereachRequest) preRequest(requestParams,
				RegRecordSereachRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());
		String xmlPath;
		if (requestBody.getHisOrdNum() == 0) {
			xmlPath = "classpath:hisResult/regRecord-info/regRecordSereach-response.xml";
		} else {
			xmlPath = "classpath:hisResult/regRecord-info/regRecordSereach-response-all.xml";
		}

		return readToString(xmlPath);
	}

	/**
	 * 预约支付。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 预约支付信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/Pay_YYRegister", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getPaymentSereach(@RequestBody String requestParams) throws JAXBException, IOException {
		AppointPaymentRequest requestBody = (AppointPaymentRequest) preRequest(requestParams,
				AppointPaymentRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPsOrdNum());

		String xmlPath = "classpath:hisResult/appointPayment-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 取消预约。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 预约支付信息
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/UnLock_YYRegeister", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String cancelAppointment(@RequestBody String requestParams) throws JAXBException, IOException {
		AppointmentCancelRequest requestBody = (AppointmentCancelRequest) preRequest(requestParams,
				AppointmentCancelRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPsOrdNum());

		String xmlPath = "classpath:hisResult/appointmentCancel-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 门诊待缴费记录查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 门诊待缴费记录
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/MZDJFJLCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getPayRecordSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		PayRecordSereachRequest requestBody = (PayRecordSereachRequest) preRequest(requestParams,
				PayRecordSereachRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "classpath:hisResult/payDetail-info/payRecordSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 缴费明细查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 缴费明细
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/MZDJFJLMXCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getPayDetailSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		PayDetailSereachRequest requestBody = (PayDetailSereachRequest) preRequest(requestParams,
				PayDetailSereachRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "";
		if (8261133 == requestBody.getHisOrdNum()) {
			xmlPath = "classpath:hisResult/payDetail-info/payDetailSereach-01-response.xml";
		} else {
			xmlPath = "classpath:hisResult/payDetail-info/payDetailSereach-02-response.xml";
		}

		return readToString(xmlPath);
	}

	/**
	 * 检查结果列表查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 检查结果列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/JCJGLBCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getInspResultListSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		InspResultListSereachRequest requestBody = (InspResultListSereachRequest) preRequest(requestParams,
				InspResultListSereachRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());
		logger.info("deptCode:" + requestBody.getBeginDate());
		logger.info("deptCode:" + requestBody.getEndDate());

		String xmlPath = "classpath:hisResult/reportSereach-info/inspResultListSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 检验报告列表查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 检验报告列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/JYBGLBCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getInspReportListSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		InspReportListSereachRequest requestBody = (InspReportListSereachRequest) preRequest(requestParams,
				InspReportListSereachRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());
		logger.info("deptCode:" + requestBody.getBeginDate());
		logger.info("deptCode:" + requestBody.getEndDate());

		String xmlPath = "classpath:hisResult/reportSereach-info/inspReportListSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 体检报告列表查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 体检报告列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/TJBGLBCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getPhyExamReportListSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		PhyExamReportListSereachRequest requestBody = (PhyExamReportListSereachRequest) preRequest(requestParams,
				PhyExamReportListSereachRequest.class);
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatName());
		logger.info("deptCode:" + requestBody.getBeginDate());
		logger.info("deptCode:" + requestBody.getEndDate());

		String xmlPath = "classpath:hisResult/reportSereach-info/phyExamReportListSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 检查结果详情查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 检查结果列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/JCJGXQCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getInspResultDetailSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		InspResultDetailSereachRequest requestBody = (InspResultDetailSereachRequest) preRequest(requestParams,
				InspResultDetailSereachRequest.class);
		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("checkId:" + requestBody.getCheckId());

		String xmlPath = "classpath:hisResult/reportSereach-info/inspResultDetailSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 检验报告详情查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 检验报告列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/JYBGXQCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getInspReportDetailSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		InspReportDetailSereachRequest requestBody = (InspReportDetailSereachRequest) preRequest(requestParams,
				InspReportDetailSereachRequest.class);
		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("inspectId:" + requestBody.getInspectId());

		String xmlPath = "classpath:hisResult/reportSereach-info/inspReportDetailSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 体检报告详情查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 体检报告列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/TJBGXQCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getPhyExamReportDetailSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		PhyExamReportDetailSereachRequest requestBody = (PhyExamReportDetailSereachRequest) preRequest(requestParams,
				PhyExamReportDetailSereachRequest.class);
		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());
		logger.info("patName:" + requestBody.getPatName());
		logger.info("phyExamId:" + requestBody.getPhyExamId());

		String xmlPath = "classpath:hisResult/reportSereach-info/phyExamReportDetailSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 体检项目详情查询。
	 * 
	 * @param requestBody
	 *            requestBody
	 * @return 体检报告列表
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/TJXMXQCX", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getPhyExamItemDetailSereach(@RequestBody String requestParams) throws JAXBException, IOException {

		PhyExamItemDetailSereachRequest requestBody = (PhyExamItemDetailSereachRequest) preRequest(requestParams,
				PhyExamItemDetailSereachRequest.class);
		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());
		logger.info("patName:" + requestBody.getPatName());
		logger.info("phyExamId:" + requestBody.getPhyExamId());
		logger.info("itemId:" + requestBody.getItemId());

		String xmlPath = "classpath:hisResult/reportSereach-info/phyExamItemDetailSereach-response.xml";

		return readToString(xmlPath);
	}

	/**
	 * 住院记录查询。
	 * 
	 * @param String
	 *            requestParams
	 * @return 住院记录
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/ZYJLCX", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getHospitalizationRecord(@RequestBody String requestParams) throws JAXBException, IOException {

		HospitalizationRecordRequest requestBody = (HospitalizationRecordRequest) preRequest(requestParams, HospitalizationRecordRequest.class);

		// 日志中输出相关信息
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("patCardNo:" + requestBody.getPatCardNo());

		String xmlPath = "classpath:hisResult/hospitalization-record/hospitalization-record-patNo" + requestBody.getPatCardNo() + "-response.xml";
		return readToString(xmlPath);
	}

	/**
	 * 住院费用清单查询。
	 * 
	 * @param String
	 *            requestParams
	 * @return 住院记录
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/ZYFYQDCX", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String getHospitalizationFee(@RequestBody String requestParams) throws JAXBException, IOException {

		HospitalizationFeeRequest requestBody = (HospitalizationFeeRequest) preRequest(requestParams, HospitalizationFeeRequest.class);

		// 日志中输出相关信息
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("patCardNo:" + requestBody.getPatCardNo());

		String xmlPath = "classpath:hisResult/hospitalization-fee/hospitalization-fee-" + requestBody.getBeginDate() + "-response.xml";
		return readToString(xmlPath);
	}

	/**
	 * 住院押金补缴支付通知。
	 * 
	 * @param String
	 *            requestParams
	 * @return 住院记录
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/ZYYJBJZF", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String depositPayNotice(@RequestBody String requestParams) throws JAXBException, IOException {

		DepositPayNoticeRequest requestBody = (DepositPayNoticeRequest) preRequest(requestParams, DepositPayNoticeRequest.class);

		// 日志中输出相关信息
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("patCardNo:" + requestBody.getPatCardNo());

		String xmlPath = "classpath:hisResult/pay-notice/deposit-pay-notice-" + "response.xml";
		return readToString(xmlPath);
	}
	
	/**
	 * 门诊缴费支付通知。
	 * 
	 * @param String
	 *            requestParams
	 * @return 门诊缴费支付
	 * @throws JAXBException
	 * @throws IOException
	 */
	@RequestMapping(value = "his/MZJFDDZF", method = { RequestMethod.POST }, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String clinicPaymentHisNotice(@RequestBody String requestParams) throws JAXBException, IOException {

		ClinicPayNoticeRequest requestBody = (ClinicPayNoticeRequest) preRequest(requestParams, ClinicPayNoticeRequest.class);

		// 日志中输出相关信息
		logger.info("hisOrdNum:" + requestBody.getHisOrdNum());
		logger.info("psOrdNum:" + requestBody.getPsOrdNum());

		String xmlPath = "classpath:hisResult/pay-notice/clinic-pay-notice-" + "response.xml";
		return readToString(xmlPath);
	}

	@SuppressWarnings("unchecked")
	private <E extends BaseRequest> E preRequest(String requestParams, Class<?> clazz) throws JAXBException {
		// System.out.println(requestParams);
		List<NameValuePair> nvp = URLEncodedUtils.parse(requestParams, StandardCharsets.UTF_8);
		// xmlText=
		String xmlText = nvp.get(0).getValue();

		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
		return (E) jaxbUnmarshaller.unmarshal(new StringReader(xmlText));
	}

	@SuppressWarnings("unchecked")
	private <T extends BaseResponse> T getResponseFromXml(Class<?> clazz, String xmlPath) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller unMarshaller = jc.createUnmarshaller();
		return (T) unMarshaller.unmarshal(new File(xmlPath));
	}

	private String readToString(String fileName) throws IOException {
		String encoding = "UTF-8";

		Resource resource = new FileSystemResourceLoader().getResource(fileName);
		File file = resource.getFile();
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];
		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String escapeXml = StringEscapeUtils.escapeXml(new String(filecontent, encoding));
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<string xmlns=\"http://tempuri.org/\">");
			sb.append(escapeXml);
			sb.append("</string>");
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			System.err.println("does not support " + encoding);
			e.printStackTrace();
			return null;
		}
	}
}
