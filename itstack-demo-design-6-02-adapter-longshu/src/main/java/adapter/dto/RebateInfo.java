package adapter.dto;

import java.util.Date;

/**
 * 统一mq消息类
 * mq接受到消息后，通过转换为当前业务统一的消息体，便于统一处理
 * @author longshu
 */
public class RebateInfo {
    /**
     * 用户ID
     */
    private String userId;

    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 业务时间
     */
    private Date bizTime;

    /**
     * 业务描述
     */
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Date getBizTime() {
        return bizTime;
    }

    public void setBizTime(Date bizTime) {
        this.bizTime = bizTime;
    }
    public void setBizTime(String bizTime) {
        this.bizTime = new Date(Long.parseLong(bizTime));
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
