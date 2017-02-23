package cn.com.liandisys.ahis.webapp.his.logic.wx3h;

import cn.com.liandisys.ahis.webapp.annotation.Logic;
import cn.com.liandisys.ahis.webapp.code.HospitalCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractPaymentRecordHisExecuteLogic;

@Logic
public class PaymentRecordHisExecuteWx3hLogic extends AbstractPaymentRecordHisExecuteLogic {

	@Override
	protected HospitalCode getHospitalCode() {
		return HospitalCode.WX3H;	
	}

}
