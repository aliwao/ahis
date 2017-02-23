package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.DoctorBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DoctorBaseHisResponse;

public abstract class AbstractDoctorHisExecuteLogic extends AbstractHisExecuteLogic<DoctorBaseHisRequest, DoctorBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return DoctorBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYDOCTORINFO;
    };
}
