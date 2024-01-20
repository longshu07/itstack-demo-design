package composite.model.vo;

/**
 * 规则树节点链路信息
 * @author longshu
 */
public class TreeNodeLink {

    /**
     * 节点来源From
     */
    private Long nodeIdFrom;        

    /**
     * 节点指向的下一个节点To
     */
    private Long nodeIdTo;          

    /**
     * 限定类型（节点的比对方式）：1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围]
     */
    private Integer ruleLimitType;  

    /**
     * 限定值（节点的比对值）
     */
    private String ruleLimitValue;

    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }
}
