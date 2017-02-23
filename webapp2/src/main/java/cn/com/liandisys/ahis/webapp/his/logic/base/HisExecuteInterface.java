package cn.com.liandisys.ahis.webapp.his.logic.base;

import cn.com.liandisys.ahis.webapp.his.entity.request.base.AbstractHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AbstractHisResponse;

public interface HisExecuteInterface<Req extends AbstractHisRequest, Res extends AbstractHisResponse> {

    boolean isExecutable(String hospitalCode, String hisExecuteTypeCode);

    Res execute(Req req);
}
