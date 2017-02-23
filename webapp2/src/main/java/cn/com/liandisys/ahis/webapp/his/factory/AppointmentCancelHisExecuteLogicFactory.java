package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractAppointmentCancelHisExecuteLogic;

@Component
public class AppointmentCancelHisExecuteLogicFactory
		extends AbstractHisExecuteLogicFactory<AbstractAppointmentCancelHisExecuteLogic> {

	protected AppointmentCancelHisExecuteLogicFactory() {
		super(AbstractAppointmentCancelHisExecuteLogic.class, HisExecuteTypeCode.QUERYAPPOINTCANCEL.code());
	}

}
