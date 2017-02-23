package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractHospitalizationFeeHisExecuteLogic;

@Component
public class HospitalizationFeeHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractHospitalizationFeeHisExecuteLogic> {

    public HospitalizationFeeHisExecuteLogicFactory() {
		super(AbstractHospitalizationFeeHisExecuteLogic.class, HisExecuteTypeCode.QUERYZYFYQDCX.code());
    }

}
