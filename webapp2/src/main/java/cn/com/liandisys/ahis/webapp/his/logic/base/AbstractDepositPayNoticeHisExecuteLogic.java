package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.DepositPayNoticeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DepositPayNoticeBaseHisResponse;

public abstract class AbstractDepositPayNoticeHisExecuteLogic extends
		AbstractHisExecuteLogic<DepositPayNoticeBaseHisRequest, DepositPayNoticeBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return DepositPayNoticeBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYZYYJBJZF;
    };
}
