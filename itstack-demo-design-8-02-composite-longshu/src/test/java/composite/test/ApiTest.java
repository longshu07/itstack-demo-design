package composite.test;

import com.alibaba.fastjson.JSON;
import composite.model.aggregates.TreeRich;
import composite.model.vo.EngineResult;
import composite.model.vo.TreeNode;
import composite.model.vo.TreeNodeLink;
import composite.model.vo.TreeRoot;
import composite.service.engine.impl.TreeEngineHandle;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private TreeRich treeRich;


    /**
     *
     * ·重要，这一部分是组合模式非常重要的使用，在我们已经建造好的决策树关系下，可以创建出树的
     * 各个节点，以及对节点间使用链路进行串联。
     * ·及时后续你需要做任何业务的扩展都可以在里面添加相应的节点，并做动态化的配置。
     * ·关于这部分手动组合的方式可以提取到数据库中，那么也就可以扩展到图形界面的进行配置操作。
     */
    @Before
    public void init() {
        // 规则树ID
        Long treeId = 10001L;
        // 节点：1
        TreeNode treeNode_01 = new TreeNode();
        // 规则树ID
        treeNode_01.setTreeId(treeId);
        // 规则树节点ID
        treeNode_01.setTreeNodeId(1L);
        // 节点类型；1子叶、2果实（最后的结果）
        treeNode_01.setNodeType(1);
        // 果实值
        treeNode_01.setNodeValue(null);
        treeNode_01.setRuleKey("userGender");
        treeNode_01.setRuleDesc("用户性别[男/女]");
        // 链接：1->11
        TreeNodeLink treeNodeLink_11 = new TreeNodeLink();
        treeNodeLink_11.setNodeIdFrom(1L);
        treeNodeLink_11.setNodeIdTo(11L);
        // 限定类型（节点的比对方式）
        treeNodeLink_11.setRuleLimitType(1);
        //  限定值（节点的比对值）
        treeNodeLink_11.setRuleLimitValue("man");

        // 链接：1->12
        TreeNodeLink treeNodeLink_12 = new TreeNodeLink();
        treeNodeLink_12.setNodeIdFrom(1L);
        treeNodeLink_12.setNodeIdTo(12L);
        treeNodeLink_12.setRuleLimitType(1);
        treeNodeLink_12.setRuleLimitValue("woman");

        List<TreeNodeLink> treeNodeLinkList_1 = new ArrayList<>();
        treeNodeLinkList_1.add(treeNodeLink_11);
        treeNodeLinkList_1.add(treeNodeLink_12);
        // treeNode_01将链接结果设置到节点信息中
        treeNode_01.setTreeNodeLinkList(treeNodeLinkList_1);

        // 节点：11
        TreeNode treeNode_11 = new TreeNode();
        treeNode_11.setTreeId(treeId);
        treeNode_11.setTreeNodeId(11L);
        // 节点类型；1子叶、2果实（最后的结果）
        treeNode_11.setNodeType(1);
        // // 果实值
        treeNode_11.setNodeValue(null);
        treeNode_11.setRuleKey("userAge");
        treeNode_11.setRuleDesc("用户年龄");

        // 链接：11->111
        // 3小于25岁
        TreeNodeLink treeNodeLink_111 = new TreeNodeLink();
        treeNodeLink_111.setNodeIdFrom(11L);
        treeNodeLink_111.setNodeIdTo(111L);
        // 3小于25岁
        treeNodeLink_111.setRuleLimitType(3);
        treeNodeLink_111.setRuleLimitValue("25");


        // 链接：11->112
        // 4大于等于25岁
        TreeNodeLink treeNodeLink_112 = new TreeNodeLink();
        treeNodeLink_112.setNodeIdFrom(11L);
        treeNodeLink_112.setNodeIdTo(112L);
        // 4大于等于25岁
        treeNodeLink_112.setRuleLimitType(4);
        treeNodeLink_112.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_11 = new ArrayList<>();
        treeNodeLinkList_11.add(treeNodeLink_111);
        treeNodeLinkList_11.add(treeNodeLink_112);

        treeNode_11.setTreeNodeLinkList(treeNodeLinkList_11);

        // 节点：12
        TreeNode treeNode_12 = new TreeNode();
        treeNode_12.setTreeId(treeId);
        treeNode_12.setTreeNodeId(12L);
        treeNode_12.setNodeType(1);
        treeNode_12.setNodeValue(null);
        treeNode_12.setRuleKey("userAge");
        treeNode_12.setRuleDesc("用户年龄");

        // 链接：12->121
        TreeNodeLink treeNodeLink_121 = new TreeNodeLink();
        treeNodeLink_121.setNodeIdFrom(12L);
        treeNodeLink_121.setNodeIdTo(121L);
        // 3小于25岁
        treeNodeLink_121.setRuleLimitType(3);
        treeNodeLink_121.setRuleLimitValue("25");

        // 链接：12->122
        TreeNodeLink treeNodeLink_122 = new TreeNodeLink();
        treeNodeLink_122.setNodeIdFrom(12L);
        treeNodeLink_122.setNodeIdTo(122L);
        treeNodeLink_122.setRuleLimitType(4);
        treeNodeLink_122.setRuleLimitValue("25");

        List<TreeNodeLink> treeNodeLinkList_12 = new ArrayList<>();
        treeNodeLinkList_12.add(treeNodeLink_121);
        treeNodeLinkList_12.add(treeNodeLink_122);

        treeNode_12.setTreeNodeLinkList(treeNodeLinkList_12);

        // 节点：111
        TreeNode treeNode_111 = new TreeNode();
        treeNode_111.setTreeId(treeId);
        treeNode_111.setTreeNodeId(111L);
        treeNode_111.setNodeType(2);
        treeNode_111.setNodeValue("果实A");

        // 节点：112
        TreeNode treeNode_112 = new TreeNode();
        treeNode_112.setTreeId(treeId);
        treeNode_112.setTreeNodeId(112L);
        treeNode_112.setNodeType(2);
        treeNode_112.setNodeValue("果实B");

        // 节点：121
        TreeNode treeNode_121 = new TreeNode();
        treeNode_121.setTreeId(treeId);
        treeNode_121.setTreeNodeId(121L);
        treeNode_121.setNodeType(2);
        treeNode_121.setNodeValue("果实C");

        // 节点：122
        TreeNode treeNode_122 = new TreeNode();
        treeNode_122.setTreeId(treeId);
        treeNode_122.setTreeNodeId(122L);
        treeNode_122.setNodeType(2);
        treeNode_122.setNodeValue("果实D");

        // 树根
        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(treeId);
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("规则决策树");

        // 树节点
        Map<Long, TreeNode> treeNodeMap = new HashMap<>();
        treeNodeMap.put(1L, treeNode_01);
        treeNodeMap.put(11L, treeNode_11);
        treeNodeMap.put(12L, treeNode_12);
        treeNodeMap.put(111L, treeNode_111);
        treeNodeMap.put(112L, treeNode_112);
        treeNodeMap.put(121L, treeNode_121);
        treeNodeMap.put(122L, treeNode_122);

        treeRich = new TreeRich(treeRoot, treeNodeMap);

    }

    /**
     *
     * 在这里提供了调用的通过组织模式创建出来的流程决策树，调用的时候传入了决策树的ID,那么如
     * 果是业务开发中就可以方便的解耦决策树与业务的绑定关系，按需传入决策树ID即可。
     * ·此外入参我们还提供了需要处理；男(man)、年龄(29岁)，的参数信息。
     */
    @Test
    public void testTree() {
        logger.info("决策树组合结构信息：\r\n {}", JSON.toJSONString(treeRich));
        Long treeId = 10001L;
        String userId = "userId-Oli09pLkdjh";
        TreeEngineHandle treeEngineHandle = new TreeEngineHandle();
        // 决策物料信息（即需要判断的信息）
        Map<String, String> decisionMatter = new HashMap<>();
        decisionMatter.put("gender", "man");
        decisionMatter.put("age", "29");
        // 执行获取测试结果
        EngineResult engineResult = treeEngineHandle.process(treeId, userId, treeRich, decisionMatter);
        logger.info("测试结果：{}", JSON.toJSONString(engineResult));

    }

}
