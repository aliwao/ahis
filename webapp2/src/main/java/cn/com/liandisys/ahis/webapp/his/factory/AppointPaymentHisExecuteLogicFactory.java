package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractAppointPaymentHisExecuteLogic;

@Component
public class AppointPaymentHisExecuteLogicFactory
		extends AbstractHisExecuteLogicFactory<AbstractAppointPaymentHisExecuteLogic> {

	protected AppointPaymentHisExecuteLogicFactory() {
		super(AbstractAppointPaymentHisExecuteLogic.class, HisExecuteTypeCode.QUERYAPPOINTPAY.code());
	}

}
