package prototype.util;

import java.util.*;

/**
 * 题⽬选项乱序操作⼯具包
 * @author longshu
 */
public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     * @param option  题目
     * @param key 答案
     * @return 返回乱序后的主题
     */
    public static Topic ranDom(Map<String, String> option, String key){
        // 获取选项题目的选项值 ：<"A", "JAVA2 EE">,<"B", "JAVA2 Card">,
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<>(keySet);
        // 扰乱顺序
        Collections.shuffle(keyList);
        // 设置新的选项
        HashMap<String, String> optionNew = new HashMap<>();
        int index = 0;
        String keyNew = "";
        for (String optionKey : keySet) {
            String randomKey = keyList.get(index++);
            if (key.equals(optionKey)) {
                // 如果是答案，则赋值
                keyNew = randomKey;
            }
            //
            optionNew.put(randomKey, option.get(optionKey));
        }
        return new Topic(optionNew, keyNew);
    }



}
