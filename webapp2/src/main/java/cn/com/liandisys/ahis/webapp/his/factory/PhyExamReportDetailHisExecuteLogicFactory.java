package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPhyExamReportDetailHisExecuteLogic;

@Component
public class PhyExamReportDetailHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractPhyExamReportDetailHisExecuteLogic> {

    public PhyExamReportDetailHisExecuteLogicFactory() {
		super(AbstractPhyExamReportDetailHisExecuteLogic.class, HisExecuteTypeCode.QUERYTJBGXQCX.code());
    }

}
