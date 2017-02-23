package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDepositPayNoticeHisExecuteLogic;

@Component
public class DepositPayNoticeHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractDepositPayNoticeHisExecuteLogic> {

    public DepositPayNoticeHisExecuteLogicFactory() {
		super(AbstractDepositPayNoticeHisExecuteLogic.class, HisExecuteTypeCode.QUERYZYYJBJZF.code());
    }

}
