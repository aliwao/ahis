package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspResultListBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspResultListBaseHisResponse;

public abstract class AbstractInspResultListHisExecuteLogic extends AbstractHisExecuteLogic<InspResultListBaseHisRequest, InspResultListBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return InspResultListBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYJCJGLBCX;
    };
}
