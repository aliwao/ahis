package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.RegisterRecordBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.RegisterRecordBaseHisResponse;

public abstract class AbstractRegisterRecordHisExecuteLogic extends AbstractHisExecuteLogic<RegisterRecordBaseHisRequest, RegisterRecordBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return RegisterRecordBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
		return HisExecuteTypeCode.QUERY_YREGISTERRECORD;
    };
}
