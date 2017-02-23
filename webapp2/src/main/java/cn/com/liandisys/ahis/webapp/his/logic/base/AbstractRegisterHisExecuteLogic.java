package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.RegisterBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.RegisterBaseHisResponse;

public abstract class AbstractRegisterHisExecuteLogic extends AbstractHisExecuteLogic<RegisterBaseHisRequest, RegisterBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return RegisterBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYREGISTERINFO;
    };
}
