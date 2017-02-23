package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PhyExamReportDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PhyExamReportDetailBaseHisResponse;

public abstract class AbstractPhyExamReportDetailHisExecuteLogic extends AbstractHisExecuteLogic<PhyExamReportDetailBaseHisRequest, PhyExamReportDetailBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return PhyExamReportDetailBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYTJBGXQCX;
    };
}
