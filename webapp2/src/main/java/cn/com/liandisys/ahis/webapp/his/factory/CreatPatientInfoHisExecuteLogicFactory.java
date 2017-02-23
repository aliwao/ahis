package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractCreatPatientInfoHisExecuteLogic;

@Component
public class CreatPatientInfoHisExecuteLogicFactory
		extends AbstractHisExecuteLogicFactory<AbstractCreatPatientInfoHisExecuteLogic> {

	public CreatPatientInfoHisExecuteLogicFactory() {
		super(AbstractCreatPatientInfoHisExecuteLogic.class, HisExecuteTypeCode.QUERYCRCEATEPATIENTINFO.code());
	}
}
