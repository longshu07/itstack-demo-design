package prototype.util;

import java.util.Map;

/**
 * 主题基类
 * @author yifeiwifelongshu
 */

public class Topic {
    /**
     * 题目选项
     * key：选项序号，value：选项具体值
     * 例如：<"A", "JAVA2 EE">,<"B", "JAVA2 Card">,
     */
    private Map<String, String> option;
    /**
     * 答案 key
     */
    private  String key;

    public Topic() {
    }

    public Topic(Map<String, String> option, String key) {
        this.option = option;
        this.key = key;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
