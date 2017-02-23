package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspReportListHisExecuteLogic;

@Component
public class InspReportListHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractInspReportListHisExecuteLogic> {

    public InspReportListHisExecuteLogicFactory() {
		super(AbstractInspReportListHisExecuteLogic.class, HisExecuteTypeCode.QUERYJYBGLBCX.code());
    }

}
