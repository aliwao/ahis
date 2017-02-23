package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointmentBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointmentBaseHisResponse;

public abstract class AbstractAppointmentHisExecuteLogic
		extends AbstractHisExecuteLogic<AppointmentBaseHisRequest, AppointmentBaseHisResponse> {
	@Override
	protected Class<?> getResponseClass() {
		return AppointmentBaseHisResponse.class;
	}

	@Override
	protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYAPPOINT;
	};
}
