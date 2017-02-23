package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.HospitalizationFeeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.HospitalizationFeeBaseHisResponse;

public abstract class AbstractHospitalizationFeeHisExecuteLogic extends
		AbstractHisExecuteLogic<HospitalizationFeeBaseHisRequest, HospitalizationFeeBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return HospitalizationFeeBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYZYFYQDCX;
    };
}
