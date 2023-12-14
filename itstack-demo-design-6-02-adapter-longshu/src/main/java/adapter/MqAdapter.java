package adapter;

import adapter.dto.RebateInfo;
import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 接受mq消息的适配器
 * mq接受到消息后，通过转换为当前业务统一的消息体 @see{RebateInfo}，便于统一处理
 *  @author longshu
 */
public class MqAdapter {
    /**
     * 将原始Json字符串转换为当前业务统一的消息体 @see{RebateInfo}
     * @param originJsonString 接受的原始Json字符串
     * @param transformationMap 转换关系表。即原始Json和RebateInfo的关系
     * @return
     */
    public static RebateInfo convertToRebateInfo(String originJsonString, Map<String, Object> transformationMap) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return convertToRebateInfo(JSON.parseObject(originJsonString, Map.class)  , transformationMap);
    }

    public static RebateInfo convertToRebateInfo(Map<Object, Object> originJsonMap, Map<String, Object> transformationMap) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RebateInfo rebateInfo = new RebateInfo();
        for (Map.Entry<String, Object> entry : transformationMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            // 获取到原始json中的值
            Object originJsonValue = originJsonMap.get(value);
            // 通过反射设置值
            // TODO: 2023/12/12 可以进行获取的优化，目前只能设置String的值，如果有Integer的值的呢 
            RebateInfo.class.getMethod("set" + key.substring(0, 1).toUpperCase() + key.substring(1), String.class)
                    .invoke(rebateInfo, originJsonValue.toString());
        }
        return rebateInfo;
    }

}
