package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.DeptBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.DeptBaseHisResponse;

public abstract class AbstractDeptHisExecuteLogic extends AbstractHisExecuteLogic<DeptBaseHisRequest, DeptBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return DeptBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
        return HisExecuteTypeCode.QUERYDEPTINFO;
    };
}
