package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PaymentRecordBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PaymentRecordBaseHisResponse;

public abstract class AbstractPaymentRecordHisExecuteLogic extends AbstractHisExecuteLogic<PaymentRecordBaseHisRequest, PaymentRecordBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return PaymentRecordBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYMZDJFJLCX;
    };
}
