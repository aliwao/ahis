package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractHospitalizationHisExecuteLogic;

@Component
public class HospitalizationHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractHospitalizationHisExecuteLogic> {

    public HospitalizationHisExecuteLogicFactory() {
		super(AbstractHospitalizationHisExecuteLogic.class, HisExecuteTypeCode.QUERYZYJLCX.code());
    }

}
