package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AppointmentCancelBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AppointmentCancelBaseHisResponse;

public abstract class AbstractAppointmentCancelHisExecuteLogic
		extends AbstractHisExecuteLogic<AppointmentCancelBaseHisRequest, AppointmentCancelBaseHisResponse> {
	@Override
	protected Class<?> getResponseClass() {
		return AppointmentCancelBaseHisResponse.class;
	}

	@Override
	protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYAPPOINTCANCEL;
	};
}
