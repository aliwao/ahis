package cn.com.liandisys.ahis.webapp.his.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.ApplicationContext;

import cn.com.liandisys.ahis.webapp.annotation.Logic;
import cn.com.liandisys.ahis.webapp.code.HospitalCode;
import cn.com.liandisys.ahis.webapp.his.logic.base.AbstractHisExecuteLogic;
import cn.com.liandisys.ahis.webapp.utils.SpringUtils;
@SuppressWarnings("rawtypes")
public abstract class AbstractHisExecuteLogicFactory<T extends AbstractHisExecuteLogic> {

    protected Class<T> clazz;
    protected List<T> logicList;
    private String hisExecuteTypeCode;
    private final ConcurrentHashMap<String, T> cache;
    private static final String KEY_SEP = "\n";

    protected AbstractHisExecuteLogicFactory(Class<T> clazz, String hisExecuteTypeCode) {
        this.hisExecuteTypeCode = hisExecuteTypeCode;
        this.clazz = clazz;
        createLogicList();
        cache = new ConcurrentHashMap<String, T>();
    }

    @SuppressWarnings("unchecked")
	protected void createLogicList() {
        ApplicationContext context = SpringUtils.getApplicationContext();
        if (context == null) {
            return;
        }
        if (logicList == null) {
            logicList = new ArrayList<>();
        }

        Map<String, Object> map = context.getBeansWithAnnotation(Logic.class);
        for (String key : map.keySet()) {
            Class<?> c = map.get(key).getClass();
            if (clazz.isAssignableFrom(c)) {
                logicList.add((T) context.getBean(c));
            }
            //
        }
    }

    public T getLogic() {
        // TODO session里取得要
        String hospitalCode = HospitalCode.WX3H.code();
        String cacheKey = getCacheKey(hospitalCode, hisExecuteTypeCode);
        T cachedLogic = cache.get(cacheKey);
        if (cachedLogic != null) {
            return cachedLogic;
        }
        if (logicList == null) {
            createLogicList();
        }
        for (T logic : logicList) {
            if (logic.isExecutable(hospitalCode, hisExecuteTypeCode)) {
                T existLogic = cache.putIfAbsent(cacheKey, logic);
                return existLogic != null ? existLogic : logic;
            }
        }
        return null;
    }

    private String getCacheKey(String hospitalCode, String hisExecuteTypeCode) {
        return hospitalCode + KEY_SEP + hisExecuteTypeCode;
    }
}
