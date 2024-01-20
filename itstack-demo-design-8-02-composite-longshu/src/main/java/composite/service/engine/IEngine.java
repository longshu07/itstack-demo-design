package composite.service.engine;

import composite.model.aggregates.TreeRich;
import composite.model.vo.EngineResult;

import java.util.Map;

/**
 * 树结构-决策引擎接⼝定义
 * 对于使用方来说也同样需要定义统一的接口操作，这样的好处非常方便后续拓展出不同类型的决策
 * 引擎，也就是可以建造不同的决策工厂。
 * @author longshu
 */
public interface IEngine {

    /**
     * 执行决策过程
     * @param treeId 规则树ID
     * @param userId 用户ID
     * @param treeRich 规则树聚合对象，包含组织树信息
     * @param decisionMatter 决策物料
     * @return 决策返回对象信息
     */
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, Map<String, String> decisionMatter);
}
