package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractRegisterHisExecuteLogic;

@Component
public class RegisterHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractRegisterHisExecuteLogic> {

    public RegisterHisExecuteLogicFactory() {
		super(AbstractRegisterHisExecuteLogic.class, HisExecuteTypeCode.QUERYREGISTERINFO.code());
    }

}
