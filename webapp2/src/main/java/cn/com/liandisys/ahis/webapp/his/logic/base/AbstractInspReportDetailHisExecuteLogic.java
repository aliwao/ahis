package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspReportDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspReportDetailBaseHisResponse;

public abstract class AbstractInspReportDetailHisExecuteLogic extends AbstractHisExecuteLogic<InspReportDetailBaseHisRequest, InspReportDetailBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return InspReportDetailBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYJYBGXQCX;
    };
}
