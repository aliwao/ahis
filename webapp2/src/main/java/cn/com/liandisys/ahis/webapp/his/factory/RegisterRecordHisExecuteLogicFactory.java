package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractRegisterRecordHisExecuteLogic;

@Component
public class RegisterRecordHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractRegisterRecordHisExecuteLogic> {

    public RegisterRecordHisExecuteLogicFactory() {
		super(AbstractRegisterRecordHisExecuteLogic.class, HisExecuteTypeCode.QUERY_YREGISTERRECORD.code());
    }

}
