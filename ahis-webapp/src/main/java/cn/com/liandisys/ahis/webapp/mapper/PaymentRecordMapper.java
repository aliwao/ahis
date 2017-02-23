package cn.com.liandisys.ahis.webapp.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;

public interface PaymentRecordMapper {

	void insertPaymentRecord(PaymentRecordDto dto);

	PaymentRecordDto getPaymentRecord(String paymentNo);

	void updatePaymentNoticeByKey(@Param("paymentNo") String paymentNo, @Param("paymentNotice") String paymentNotice);
}
