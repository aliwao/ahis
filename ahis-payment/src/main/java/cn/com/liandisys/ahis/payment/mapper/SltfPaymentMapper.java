package cn.com.liandisys.ahis.payment.mapper;

import cn.com.liandisys.ahis.payment.dto.PaymentDetailDto;
import cn.com.liandisys.ahis.payment.dto.PaymentRecordDto;

public interface SltfPaymentMapper {

	/**
	 * 获取缴费记录。
	 * 
	 * @param paymentNo
	 *            缴费单号
	 * @return 缴费记录
	 */
	PaymentRecordDto getPaymentRecord(String paymentNo);

	/**
	 * 获取支付明细。
	 * 
	 * @param paymentNo
	 *            缴费单号
	 * @return 支付明细
	 */
	PaymentDetailDto getPaymentDetail(String paymentNo);

	/**
	 * 支付明细登录。
	 * 
	 * @param dto
	 *            支付明细Dto
	 * @return 登录件数
	 */
	int insertPaymentDetail(PaymentDetailDto dto);

	/**
	 * 更新支付明细表。
	 * 
	 * @param dto
	 *            支付明细Dto
	 * @return 更新件数
	 */
	int updatePaymentDetail(PaymentDetailDto dto);

	/**
	 * 更新个人缴费记录表。
	 * 
	 * @param dto
	 *            个人缴费记录Dto
	 * @return 更新件数
	 */
	int updatePaymentRecord(PaymentRecordDto dto);

}
