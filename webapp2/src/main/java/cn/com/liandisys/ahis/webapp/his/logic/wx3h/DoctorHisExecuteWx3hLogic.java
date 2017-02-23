package cn.com.liandisys.ahis.webapp.his.logic.wx3h;

import cn.com.liandisys.ahis.webapp.annotation.Logic;
import cn.com.liandisys.ahis.webapp.code.HospitalCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDoctorHisExecuteLogic;

@Logic
public class DoctorHisExecuteWx3hLogic extends AbstractDoctorHisExecuteLogic {

    @Override
    protected HospitalCode getHospitalCode() {
        return HospitalCode.WX3H;
    }

}
