package composite.service.engine.impl;

import composite.model.aggregates.TreeRich;
import composite.model.vo.EngineResult;
import composite.model.vo.TreeNode;
import composite.model.vo.TreeRoot;
import composite.service.engine.EngineConfig;
import composite.service.engine.IEngine;
import composite.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 基础决策引擎功能-抽象类
 * ·这里主要提供决策树流程的处理过程，有点像通过链路的关系（性别、年龄）在二叉树中寻找果实
 * 节点的过程。
 * ·同时提供一个抽象方法，执行决策流程的方法供外部去做具体的实现。
 * @author longshu
 */
public abstract class EngineBase extends EngineConfig implements IEngine {
    private final Logger logger = LoggerFactory.getLogger(EngineBase.class);

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
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    /**
     * 决策树流程的处理过程
     * @param treeRich  规则树聚合对象
     * @param treeId 规则树ID
     * @param userId 用户ID
     * @param decisionMatter 决策物料
     * @return TreeNode 返回果实节点信息
     */
    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter){
        TreeRoot treeRoot = treeRich.getTreeRoot();
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树根ID
        Long treeRootNodeId = treeRoot.getTreeRootNodeId();
        TreeNode treeNodeInfo = treeNodeMap.get(treeRootNodeId);
        // 节点类型【nodeType】:1子叶；2、果实
        // 知道获取到非子叶则停止
        while (Integer.valueOf(1).equals(treeNodeInfo.getNodeType())){
            String ruleKey = treeNodeInfo.getRuleKey();
            // 通过规则Key获取到对应的逻辑过滤器
            LogicFilter logicFilter = getLogicFilterMap().get(ruleKey);
            // 获取决策值
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            // 下一个节点ID
            Long nextNodeId = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            // 节点信息
            treeNodeInfo = treeNodeMap.get(nextNodeId);
            logger.info("决策树引擎（engineDecisionMaker）=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        // 返回果实节点信息
        return treeNodeInfo;
    }
}
