package cn.com.liandisys.ahis.webapp.his.factory;

import org.springframework.stereotype.Component;

import cn.com.liandisys.ahis.webapp.code.HisExecuteTypeCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractDeptHisExecuteLogic;

@Component
public class DeptHisExecuteLogicFactory extends AbstractHisExecuteLogicFactory<AbstractDeptHisExecuteLogic> {

    public DeptHisExecuteLogicFactory() {
        super(AbstractDeptHisExecuteLogic.class, HisExecuteTypeCode.QUERYDEPTINFO.code());
    }

}
