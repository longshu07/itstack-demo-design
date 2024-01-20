package composite.service.engine;

import composite.service.logic.LogicFilter;
import composite.service.logic.impl.UserAgeFilter;
import composite.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 决策节点配置
 * 在这里将可提供服务的决策节点配置到map结构中，对于这样的map结构可以抽取到数据库中，
 * 那么就可以非常方便的管理。
 * @author longshu
 */
public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;

    /**
     * 在这里将可提供服务的决策节点配置到map结构中，对于这样的map结构可以抽取到数据库中，
     * 那么就可以非常方便的管理。
     */
    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }

}
