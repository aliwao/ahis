package cn.com.liandisys.ahis.webapp.his.logic.base;

import com.alibaba.fastjson.JSONObject;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.code.HospitalCode;
import cn.com.liandisys.ahis.webapp.his.HisHttpJson;
import cn.com.liandisys.ahis.webapp.his.entity.request.base.AbstractHisRequest;
import cn.com.liandisys.ahis.webapp.his.entity.response.base.AbstractHisResponse;

public abstract class AbstractHisExecuteLogic<Req extends AbstractHisRequest, Res extends AbstractHisResponse> implements HisExecuteInterface<Req, Res> {

    /** 请求参数 */
    private JSONObject requestJson;

    /** 返回结果 */
    private JSONObject responseJson;

    protected abstract HospitalCode getHospitalCode();

    protected abstract HisExecuteTypeCode getHisExecuteTypeCode();

    protected abstract Class<?> getResponseClass();

    protected void setExecuteParamter(Req req) {
        this.requestJson = JSONObject.parseObject(JSONObject.toJSONString(req));
    }

    /**
     * 返回结果
     */
    @SuppressWarnings("unchecked")
    protected Res getExecuteResult() {
        return (Res) JSONObject.toJavaObject(responseJson, getResponseClass());
    }

    @Override
    public boolean isExecutable(String hospitalCode, String hisExecuteTypeCode) {
        return getHospitalCode().code().equals((hospitalCode))
                && getHisExecuteTypeCode().code().equals(hisExecuteTypeCode);
    }

    @Override
    public Res execute(Req req) {
        this.setExecuteParamter(req);
        String apiUri = getHisExecuteTypeCode().hisExecuteUri();
        responseJson = HisHttpJson.executeHisApi(apiUri, requestJson);
        // TODO 单个item时，数组化必要，待实现
        return getExecuteResult();
    };
}
