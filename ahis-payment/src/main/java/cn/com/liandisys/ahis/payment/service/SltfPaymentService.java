package cn.com.liandisys.ahis.payment.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.liandisys.ahis.payment.dto.PaymentDetailDto;
import cn.com.liandisys.ahis.payment.dto.PaymentRecordDto;
import cn.com.liandisys.ahis.payment.form.sltf.OrderPaymentResultForm;
import cn.com.liandisys.ahis.payment.form.sltf.QueryResultForm;
import cn.com.liandisys.ahis.payment.mapper.SltfPaymentMapper;

@Service
public class SltfPaymentService {

	@Autowired
	SltfPaymentMapper mapper;

	private static String 支付成功_20 = "20";
	private static String 支付中_10 = "10";

	/**
	 * 获取缴费记录。
	 * 
	 * @param paymentNo
	 *            缴费单号
	 * @return 缴费记录
	 */
	public PaymentRecordDto getPaymentRecord(String paymentNo) {
		return mapper.getPaymentRecord(paymentNo);
	}

	/**
	 * 获取支付明细记录。
	 * 
	 * @param paymentNo
	 *            缴费单号
	 * @return 支付明细
	 */
	public PaymentDetailDto getPaymentDetail(String paymentNo) {
		return mapper.getPaymentDetail(paymentNo);
	}

	/**
	 * 支付明细登录。
	 * 
	 * @param dto
	 *            支付明细Dto
	 * @return 登录件数
	 */
	public int insertPaymentDetail(PaymentDetailDto dto) {
		return mapper.insertPaymentDetail(dto);
	}

	/**
	 * 更新个人缴费表。
	 * 
	 * @param dto
	 *            支付明细Dto
	 * @return 更新件数
	 */
	public int updatePaymentRecord(PaymentDetailDto detailDto) {
		PaymentRecordDto dto = new PaymentRecordDto();
		dto.setPaymentNo(detailDto.getPaymentNo());
		System.out.println(">>>>>>>>>>>>>>>payment patfee>" +  detailDto.getPayFee());
		dto.setPayFee(detailDto.getPayFee());
		dto.setOrderDatetime(detailDto.getOrderDatetime());
		dto.setPaidDate(detailDto.getPaymentSuccessDateTime());
		dto.setPaidState("1");
		dto.setUpdateTime(detailDto.getUpdateTime());
		dto.setUpdateUser(detailDto.getUpdateUser());
		return mapper.updatePaymentRecord(dto);
	}

	/**
	 * 更新支付明细表。
	 * 
	 * @param dto
	 *            支付明细Dto
	 * @param queryResultForm
	 *            queryResultForm
	 * @param orderPaymentResultForm
	 *            OrderPaymentResultForm
	 * @return 更新件数
	 */
	public int updatePaymentDetail(PaymentDetailDto dto, QueryResultForm queryResultForm, OrderPaymentResultForm orderPaymentResultForm) {
		dto.setExtPayResultCode(orderPaymentResultForm.getResultcode());
		dto.setExtPayResultMsg(orderPaymentResultForm.getResultmsg());

		if ("0000".equals(orderPaymentResultForm.getResultcode()) && queryResultForm != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date payDate = null;
			try {
				payDate = sdf.parse(queryResultForm.getPaydatetime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			dto.setPaymentSuccessDateTime(new Timestamp(payDate.getTime()));
			dto.setExtPaymentId(queryResultForm.getPayorderid());
			dto.setPaymentStatus(支付成功_20);
		} else {
			dto.setPaymentStatus(支付中_10);
		}
		return mapper.updatePaymentDetail(dto);
	}

}
