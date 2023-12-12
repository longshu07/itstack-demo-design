package adapter.service;

/**
 * 订单适配器接口
 * @author longshu
 */
public interface OrderAdapterService {
    /**
     * 是否首单
     * @param uId
     * @return
     */
    boolean isFirst(String uId);
}
