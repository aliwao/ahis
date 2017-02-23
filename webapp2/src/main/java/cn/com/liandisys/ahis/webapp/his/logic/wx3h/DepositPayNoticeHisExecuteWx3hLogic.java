package cn.com.liandisys.ahis.webapp.his.logic.wx3h;

import cn.com.liandisys.ahis.webapp.annotation.Logic;
import cn.com.liandisys.ahis.webapp.code.HospitalCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDepositPayNoticeHisExecuteLogic;

@Logic
public class DepositPayNoticeHisExecuteWx3hLogic extends AbstractDepositPayNoticeHisExecuteLogic {

    @Override
    protected HospitalCode getHospitalCode() {
        return HospitalCode.WX3H;
    }

}
