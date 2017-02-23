package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspResultDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspResultDetailBaseHisResponse;

public abstract class AbstractInspResultDetailHisExecuteLogic extends AbstractHisExecuteLogic<InspResultDetailBaseHisRequest, InspResultDetailBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return InspResultDetailBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYJCJGXQCX;
    };
}
