package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.CreatPatientInfoBaseHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.CreatPatientInfoBaseHisResponse;

public abstract class AbstractCreatPatientInfoHisExecuteLogic
		extends AbstractHisExecuteLogic<CreatPatientInfoBaseHisRequest, CreatPatientInfoBaseHisResponse> {

	@Override
	protected Class<?> getResponseClass() {
		return CreatPatientInfoBaseHisResponse.class;
	}

    @Override
    protected HisExecuteTypeCode getHisExecuteTypeCode() {
        return HisExecuteTypeCode.QUERYCRCEATEPATIENTINFO;
    };
}
