package composite.service.engine.impl;

import composite.model.aggregates.TreeRich;
import composite.model.vo.EngineResult;
import composite.model.vo.TreeNode;

import java.util.Map;

/**
 * 决策引擎的实现
 * ·这里对于决策引擎的实现就非常简单了，
 * 通过传递进来的必要信息：决策树信息、决策物料值，来做具体的树形结构决策。
 * @author longshu
 */
public class TreeEngineHandle extends EngineBase{
    /**
     * 执行决策过程
     *
     * @param treeId         规则树ID
     * @param userId         用户ID
     * @param treeRich       规则树聚合对象，包含组织树信息
     * @param decisionMatter 决策物料
     * @return 决策返回对象信息
     */
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程，获得决策结果
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId,decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
