package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PhyExamReportListBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PhyExamReportListBaseHisResponse;

public abstract class AbstractPhyExamReportListHisExecuteLogic extends AbstractHisExecuteLogic<PhyExamReportListBaseHisRequest, PhyExamReportListBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return PhyExamReportListBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYTJBGLBCX;
    };
}
