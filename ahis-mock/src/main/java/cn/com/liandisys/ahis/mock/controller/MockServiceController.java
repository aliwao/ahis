package cn.com.liandisys.ahis.mock.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.com.liandisys.ahis.mock.entity.BaseResponse;
import cn.com.liandisys.ahis.mock.entity.request.AppointPaymentRequest;
import cn.com.liandisys.ahis.mock.entity.request.AppointmentRequest;
import cn.com.liandisys.ahis.mock.entity.request.DoctorInfoRequest;
import cn.com.liandisys.ahis.mock.entity.request.HospitalDeptRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspReportDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspReportListSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspResultDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.InspResultListSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PayDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PayRecordSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PhyExamReportDetailSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.PhyExamReportListSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.RegRecordSereachRequest;
import cn.com.liandisys.ahis.mock.entity.request.RegisterInfoRequest;
import cn.com.liandisys.ahis.mock.entity.response.AppointPaymentResponse;
import cn.com.liandisys.ahis.mock.entity.response.AppointmentResponse;
import cn.com.liandisys.ahis.mock.entity.response.DoctorInfoResponse;
import cn.com.liandisys.ahis.mock.entity.response.HospitalDeptResponse;
import cn.com.liandisys.ahis.mock.entity.response.InspReportDetailSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.InspReportListSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.InspResultDetailSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.InspResultListSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.PayDetailSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.PayRecordSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.PhyExamReportDetailSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.PhyExamReportListSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.RegRecordSereachResponse;
import cn.com.liandisys.ahis.mock.entity.response.RegisterInfoResponse;

@RestController
@RequestMapping("/mock")
public class MockServiceController {

	private static final Logger logger = LoggerFactory.getLogger(MockServiceController.class);

	@RequestMapping(value = "his/hospital-dept", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public HospitalDeptResponse getHostipalDept(@RequestBody HospitalDeptRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());

		String xmlPath = "/var/his/hospital-dept-response.xml";

		// 根据业务楼继需求，返回不同内容的xml
		// if ("01".equals(requestBody.getDeptCode())) {
		// xmlPath = "/var/his/hospital-dept-01-response.xml";
		// } else {
		// xmlPath = "/var/his/hospital-dept-02-response.xml";
		// }

		return getResponseFromXml(HospitalDeptResponse.class, xmlPath);
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
	@RequestMapping(value = "his/register-info", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public RegisterInfoResponse getRegisterInfo(@RequestBody RegisterInfoRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());
		String xmlPath;
		if (requestBody.getDoctorCode() == null || requestBody.getDoctorCode().isEmpty()) {
			xmlPath = "/var/his/register-info/register-info-dept" + requestBody.getDeptCode() + "-response.xml";
		} else {
			logger.info("doctorCode:" + requestBody.getDoctorCode());
			xmlPath = "/var/his/register-info/register-info-personal" + requestBody.getDoctorCode() + "-response.xml";
		}

		return getResponseFromXml(RegisterInfoResponse.class, xmlPath);
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
		String xmlPath = "/var/his/dept-info/dept-info-dept" + requestBody.getDeptCode() + "-response.xml";
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
	@RequestMapping(value = "his/doctor-info", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public DoctorInfoResponse getDoctorInfo(@RequestBody DoctorInfoRequest requestBody)
			throws JAXBException, IOException {
		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getDeptCode());
		String xmlPath;
		if (requestBody.getDoctorCode() == null || requestBody.getDoctorCode().isEmpty()) {
			xmlPath = "/var/his/doctor-info/doctor-info-dept" + requestBody.getDeptCode() + "-response.xml";
		} else {
			logger.info("doctorCode:" + requestBody.getDoctorCode());
			xmlPath = "/var/his/doctor-info/doctor-info-personal" + requestBody.getDoctorCode() + "-response.xml";
		}

		return getResponseFromXml(DoctorInfoResponse.class, xmlPath);
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
	@RequestMapping(value = "his/appointment", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public AppointmentResponse getRegRecordSereach(@RequestBody AppointmentRequest requestBody)
			throws JAXBException, IOException {

		logger.info("psOrdNum:" + requestBody.getPsOrdNum());
		// logger.info("deptCode:" + requestBody.getPatCardNo());
		// logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "/var/his/appointment-response.xml";

		return getResponseFromXml(AppointmentResponse.class, xmlPath);
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
	@RequestMapping(value = "his/regRecordSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public RegRecordSereachResponse getRegRecordSereach(@RequestBody RegRecordSereachRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "/var/his/regRecordSereach-response.xml";

		return getResponseFromXml(RegRecordSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/appointPayment", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public AppointPaymentResponse getPaymentSereach(@RequestBody AppointPaymentRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPsOrdNum());

		String xmlPath = "/var/his/appointPayment-response.xml";

		return getResponseFromXml(AppointPaymentResponse.class, xmlPath);
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
	@RequestMapping(value = "his/payRecordSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public PayRecordSereachResponse getPayRecordSereach(@RequestBody PayRecordSereachRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "/var/his/payRecordSereach-response.xml";

		return getResponseFromXml(PayRecordSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/payDetailSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public PayDetailSereachResponse getPayDetailSereach(@RequestBody PayDetailSereachRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getHisOrdNum());
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());

		String xmlPath = "";
		if (8261133 == requestBody.getHisOrdNum()) {
			xmlPath = "/var/his/payDetailSereach-01-response.xml";
		} else {
			xmlPath = "/var/his/payDetailSereach-02-response.xml";
		}

		return getResponseFromXml(PayDetailSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/inspResultListSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public InspResultListSereachResponse getInspResultListSereach(@RequestBody InspResultListSereachRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());
		logger.info("deptCode:" + requestBody.getBeginDate());
		logger.info("deptCode:" + requestBody.getEndDate());

		String xmlPath = "/var/his/inspResultListSereach-response.xml";

		return getResponseFromXml(InspResultListSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/inspReportListSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public InspReportListSereachResponse getInspReportListSereach(@RequestBody InspReportListSereachRequest requestBody)
			throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatCardType());
		logger.info("deptCode:" + requestBody.getBeginDate());
		logger.info("deptCode:" + requestBody.getEndDate());

		String xmlPath = "/var/his/inspReportListSereach-response.xml";

		return getResponseFromXml(InspReportListSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/phyExamReportListSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public PhyExamReportListSereachResponse getPhyExamReportListSereach(
			@RequestBody PhyExamReportListSereachRequest requestBody) throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("deptCode:" + requestBody.getPatCardNo());
		logger.info("deptCode:" + requestBody.getPatName());
		logger.info("deptCode:" + requestBody.getBeginDate());
		logger.info("deptCode:" + requestBody.getEndDate());

		String xmlPath = "/var/his/phyExamReportListSereach-response.xml";

		return getResponseFromXml(PhyExamReportListSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/inspResultDetailSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public InspResultDetailSereachResponse getInspResultDetailSereach(
			@RequestBody InspResultDetailSereachRequest requestBody) throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("checkId:" + requestBody.getCheckId());

		String xmlPath = "/var/his/inspResultDetailSereach-response.xml";

		return getResponseFromXml(InspResultDetailSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/inspReportDetailSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public InspReportDetailSereachResponse getInspReportDetailSereach(
			@RequestBody InspReportDetailSereachRequest requestBody) throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());
		logger.info("patCardType:" + requestBody.getPatCardType());
		logger.info("inspectId:" + requestBody.getInspectId());

		String xmlPath = "/var/his/inspReportDetailSereach-response.xml";

		return getResponseFromXml(InspReportDetailSereachResponse.class, xmlPath);
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
	@RequestMapping(value = "his/phyExamReportDetailSereach", method = {
			RequestMethod.POST }, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public PhyExamReportDetailSereachResponse getPhyExamReportDetailSereach(
			@RequestBody PhyExamReportDetailSereachRequest requestBody) throws JAXBException, IOException {

		// 日志中输出相关信息
		logger.info("patCardNo:" + requestBody.getPatCardNo());	
		logger.info("patName:" + requestBody.getPatName());
		logger.info("phyExamId:" + requestBody.getPhyExamId());

		String xmlPath = "/var/his/phyExamReportDetailSereach-response.xml";

		return getResponseFromXml(PhyExamReportDetailSereachResponse.class, xmlPath);
	}

	@SuppressWarnings("unchecked")
	private <T extends BaseResponse> T getResponseFromXml(Class<?> clazz, String xmlPath) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller unMarshaller = jc.createUnmarshaller();
		return (T) unMarshaller.unmarshal(new File(xmlPath));
	}
}
