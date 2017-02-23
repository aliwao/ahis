package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.PhyExamItemDetailBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.PhyExamItemDetailBaseHisResponse;

public abstract class AbstractPhyExamItemDetailHisExecuteLogic extends AbstractHisExecuteLogic<PhyExamItemDetailBaseHisRequest, PhyExamItemDetailBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return PhyExamItemDetailBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERYTJXMXQCX;
    };
}
