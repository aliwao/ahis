package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractInspReportDetailHisExecuteLogic;

@Component
public class InspReportDetailHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractInspReportDetailHisExecuteLogic> {

    public InspReportDetailHisExecuteLogicFactory() {
		super(AbstractInspReportDetailHisExecuteLogic.class, HisExecuteTypeCode.QUERYJYBGLBCX.code());
    }

}
