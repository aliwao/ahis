package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPhyExamItemDetailHisExecuteLogic;

@Component
public class PhyExamItemDetailHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractPhyExamItemDetailHisExecuteLogic> {

    public PhyExamItemDetailHisExecuteLogicFactory() {
		super(AbstractPhyExamItemDetailHisExecuteLogic.class, HisExecuteTypeCode.QUERYTJXMXQCX.code());
    }

}
