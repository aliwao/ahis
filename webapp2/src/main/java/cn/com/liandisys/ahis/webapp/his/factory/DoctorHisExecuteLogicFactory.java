package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDoctorHisExecuteLogic;

@Component
public class DoctorHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractDoctorHisExecuteLogic> {

    public DoctorHisExecuteLogicFactory() {
		super(AbstractDoctorHisExecuteLogic.class, HisExecuteTypeCode.QUERYDOCTORINFO.code());
    }

}
