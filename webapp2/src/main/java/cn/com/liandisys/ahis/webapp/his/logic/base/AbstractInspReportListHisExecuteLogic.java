package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.InspReportListBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.InspReportListBaseHisResponse;

public abstract class AbstractInspReportListHisExecuteLogic extends AbstractHisExecuteLogic<InspReportListBaseHisRequest, InspReportListBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return InspReportListBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYJYBGLBCX;
    };
}
