package cn.com.liandisys.ahis.webapp.his.logic.wx3h;

import cn.com.liandisys.ahis.webapp.annotation.Logic;
import cn.com.liandisys.ahis.webapp.code.HospitalCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractHospitalizationHisExecuteLogic;

@Logic
public class HospitalizaitonFeeHisExecuteWx3hLogic extends AbstractHospitalizationHisExecuteLogic {

    @Override
    protected HospitalCode getHospitalCode() {
        return HospitalCode.WX3H;
    }

}
