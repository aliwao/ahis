package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPhyExamReportListHisExecuteLogic;

@Component
public class PhyExamReportListHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractPhyExamReportListHisExecuteLogic> {

    public PhyExamReportListHisExecuteLogicFactory() {
		super(AbstractPhyExamReportListHisExecuteLogic.class, HisExecuteTypeCode.QUERYTJBGLBCX.code());
    }

}
