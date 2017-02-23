package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.HospitalizationBaseHisResponse;

public abstract class AbstractHospitalizationHisExecuteLogic extends
		AbstractHisExecuteLogic<HospitalizationBaseHisRequest, HospitalizationBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return HospitalizationBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYZYJLCX;
    };
}
