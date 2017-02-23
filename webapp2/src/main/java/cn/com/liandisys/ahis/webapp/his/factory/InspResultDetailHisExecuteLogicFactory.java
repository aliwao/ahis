package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspResultDetailHisExecuteLogic;

@Component
public class InspResultDetailHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractInspResultDetailHisExecuteLogic> {

    public InspResultDetailHisExecuteLogicFactory() {
		super(AbstractInspResultDetailHisExecuteLogic.class, HisExecuteTypeCode.QUERYJCJGXQCX.code());
    }

}
