package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.ClinicPayNoticeBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.ClinicPayNoticeBaseHisResponse;

public abstract class AbstractClinicPayNoticeBaseHisExecuteLogic
		extends AbstractHisExecuteLogic<ClinicPayNoticeBaseHisRequest, ClinicPayNoticeBaseHisResponse> {
	@Override
	protected Class<?> getResponseClass() {
		return ClinicPayNoticeBaseHisResponse.class;
	}

	@Override
	protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYMZJFDDZF;
	};
}
