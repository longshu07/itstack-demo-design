package composite.service.logic.impl;

import java.util.Map;

/**
 * 用户性别决策过滤器
 * @author longshu
 */
public class UserGenderFilter extends BaseLogicFilter{
    /**
     * 获取决策值
     * 决策逻辑的节点获取值的⽅式都⾮常简单，只是获取⽤户的⼊参即可。实际的业务开发可
     * 以从数据库、RPC接⼝、缓存运算等各种⽅式获取。
     * @param treeId         规则树ID
     * @param userId         用户ID
     * @param decisionMatter 决策物料
     * @return
     */
    @Override
    public String matterValue(Long treeId, String userId, Map<String, String> decisionMatter) {
        return decisionMatter.get("gender");
    }
}
