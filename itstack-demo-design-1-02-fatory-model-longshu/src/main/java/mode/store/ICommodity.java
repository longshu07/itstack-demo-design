package mode.store;

import java.util.Map;

/**
 * 抽象商品接口
 * @author  longshu
 */
public interface ICommodity {
    /**
     * 发送商品
     * @param uId
     * @param commodityId
     * @param bizId
     * @param extMap
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
