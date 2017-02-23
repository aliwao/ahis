package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspResultListHisExecuteLogic;

@Component
public class InspResultListHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractInspResultListHisExecuteLogic> {

    public InspResultListHisExecuteLogicFactory() {
		super(AbstractInspResultListHisExecuteLogic.class, HisExecuteTypeCode.QUERYJCJGLBCX.code());
    }

}
