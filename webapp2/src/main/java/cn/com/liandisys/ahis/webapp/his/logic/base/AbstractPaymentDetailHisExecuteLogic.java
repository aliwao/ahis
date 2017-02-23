package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PaymentDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PaymentDetailBaseHisResponse;

public abstract class AbstractPaymentDetailHisExecuteLogic extends AbstractHisExecuteLogic<PaymentDetailBaseHisRequest, PaymentDetailBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return PaymentDetailBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYMZDJFJLMXCX;
    };
}
