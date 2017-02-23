package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPaymentDetailHisExecuteLogic;

@Component
public class PaymentDetailHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractPaymentDetailHisExecuteLogic> {

    public PaymentDetailHisExecuteLogicFactory() {
		super(AbstractPaymentDetailHisExecuteLogic.class, HisExecuteTypeCode.QUERYMZDJFJLMXCX.code());
    }

}
