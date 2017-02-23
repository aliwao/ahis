package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractClinicPayNoticeBaseHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.his.logic.wx3h.AppointmentHisExecuteWx3hLogic;

@Component
public class ClinicPayNoticeExecuteLogicFactory
		extends AbstractHisExecuteLogicFactory<AbstractClinicPayNoticeBaseHisExecuteLogic> {

	protected ClinicPayNoticeExecuteLogicFactory() {
		super(AbstractClinicPayNoticeBaseHisExecuteLogic.class, HisExecuteTypeCode.QUERYMZJFDDZF.code());
	}

}
