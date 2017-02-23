package cn.com.liandisys.ahis.webapp.mapper;

import java.util.List;

import cn.com.liandisys.ahis.webapp.dto.PaymentRecordDto;

public interface Mfop001Mapper {

	List<PaymentRecordDto> getHasPaid(int userId);
	
	int getRegisterHistory(String hisOrdNum);
	
	int getPaymentRecord(String hisOrdNum);
}
