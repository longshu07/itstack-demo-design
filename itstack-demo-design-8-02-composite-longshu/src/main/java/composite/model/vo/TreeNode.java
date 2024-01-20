package composite.model.vo;

import java.util.List;

/**
 * 规则树节点信息
 * 树节点；⼦叶节点、果实节点
 * @author longshu
 */
public class TreeNode {
    /**
     * 规则树ID
     */
    private Long treeId;             
    
    /**
     * 规则树节点ID
     */
    private Long treeNodeId;         

    /**
     * 节点类型；1子叶、2果实（最后的结果）
     */
    private Integer nodeType;        

    /**
     * 节点值[nodeType=2]；果实值
     */
    private String nodeValue;        

    /**
     * 规则Key
     */
    private String ruleKey;          

    /**
     * 规则描述
     */
    private String ruleDesc;         

    /**
     * 节点链路
     */
    private List<TreeNodeLink> treeNodeLinkList;

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public List<TreeNodeLink> getTreeNodeLinkList() {
        return treeNodeLinkList;
    }

    public void setTreeNodeLinkList(List<TreeNodeLink> treeNodeLinkList) {
        this.treeNodeLinkList = treeNodeLinkList;
    }
}
