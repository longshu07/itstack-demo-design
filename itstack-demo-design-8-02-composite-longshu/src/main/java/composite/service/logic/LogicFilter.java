package composite.service.logic;

import composite.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 树节点逻辑过滤器接⼝
 * 这一部分定义了适配的通用接口，逻辑决策器、获取决策值，让每一个提供决策能力的节点都必须实现此接口，保证统一性。
 *
 * @author longshu
 */
public interface LogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue      决策值
     * @param treeNodeLinkList 决策节点
     * @return 下一个节点ID
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList);

    /**
     * 获取决策值
     *
     * @param treeId         规则树ID
     * @param userId         用户ID
     * @param decisionMatter 决策物料
     * @return
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);
}
