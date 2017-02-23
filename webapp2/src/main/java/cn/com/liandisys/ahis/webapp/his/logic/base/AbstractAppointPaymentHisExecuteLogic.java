package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointPaymentBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointPaymentBaseHisResponse;

public abstract class AbstractAppointPaymentHisExecuteLogic
		extends AbstractHisExecuteLogic<AppointPaymentBaseHisRequest, AppointPaymentBaseHisResponse> {
	@Override
	protected Class<?> getResponseClass() {
		return AppointPaymentBaseHisResponse.class;
	}

	@Override
	protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYAPPOINTPAY;
	};
}
