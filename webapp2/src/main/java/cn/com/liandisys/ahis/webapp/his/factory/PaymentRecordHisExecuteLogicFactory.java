package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPaymentRecordHisExecuteLogic;

@Component
public class PaymentRecordHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractPaymentRecordHisExecuteLogic> {

    public PaymentRecordHisExecuteLogicFactory() {
		super(AbstractPaymentRecordHisExecuteLogic.class, HisExecuteTypeCode.QUERYMZDJFJLCX.code());
    }

}
