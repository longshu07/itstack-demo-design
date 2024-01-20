package composite.service.logic.impl;

import composite.model.vo.TreeNodeLink;
import composite.service.logic.LogicFilter;

import java.util.List;
import java.util.Map;

/**
 * 决策抽象类提供基础服务。
 * 定义了定义了基本的决策方法；1、2、3、4、5，等于、大于、小于、大于等于、小于等于、的判断逻辑。
 * 同时定义了抽象方法，让每一个实现接口的类都必须按照规则提供决策值，这个决策值用于做逻辑比对。
 * @author longshu
 */
public abstract class BaseLogicFilter implements LogicFilter {

    /**
     * 逻辑决策器
     *
     * @param matterValue      决策值
     * @param treeNodeLinkList 决策节点
     * @return 下一个节点ID
     */
    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLinkList) {
       for (TreeNodeLink treeNodeLink : treeNodeLinkList) {
           // 如果是当前决策逻辑，则返回下一个节点ID
           if (decisionLogic(matterValue, treeNodeLink)){
               return treeNodeLink.getNodeIdTo();
           }
       }
        return 0L;
    }

    /**
     * 获取决策值
     *
     * @param treeId         规则树ID
     * @param userId         用户ID
     * @param decisionMatter 决策物料
     * @return
     */
    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

    /**
     * 决策逻辑
     * 定义了基本的决策方法；1、2、3、4、5，等于、大于、小于、大于等于、小于等于、的判断逻辑。
     * @param matterValue 决策值
     * @param nodeLink 节点链路信息
     * @return
     */
    private boolean decisionLogic(String matterValue, TreeNodeLink nodeLink) {
        // 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
        switch (nodeLink.getRuleLimitType()) {
            case 1:
                return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2:
                return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3:
                return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4:
                return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5:
                return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            default:
                return false;
        }
    }
}
