package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractAppointmentHisExecuteLogic;

@Component
public class AppointmentHisExecuteLogicFactory
		extends AbstractHisExecuteLogicFactory<AbstractAppointmentHisExecuteLogic> {

	protected AppointmentHisExecuteLogicFactory() {
		super(AbstractAppointmentHisExecuteLogic.class, HisExecuteTypeCode.QUERYAPPOINT.code());
	}

}
