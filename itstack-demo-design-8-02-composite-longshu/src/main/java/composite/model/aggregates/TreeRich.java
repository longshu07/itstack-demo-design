package composite.model.aggregates;

import composite.model.vo.TreeNode;
import composite.model.vo.TreeRoot;

import java.util.Map;

/**
 * 规则树聚合对象，包含组织树信息
 * @author longshu
 */
public class TreeRich {

    /**
     * 树根信息
     */
    private TreeRoot treeRoot;
    //

    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNode> treeNodeMap;

    public TreeRich(TreeRoot treeRoot, Map<Long, TreeNode> treeNodeMap) {
        this.treeRoot = treeRoot;
        this.treeNodeMap = treeNodeMap;
    }

    public TreeRich() {
    }

    public TreeRoot getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRoot treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNode> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNode> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}
