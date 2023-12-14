package adapter.service.impl;

import adapter.service.OrderAdapterService;
import org.itstack.demo.design.service.OrderService;

/**
 * 内部订单服务类
 * @author  longshu
 */
public class InsideOrderAdapterServiceImpl implements OrderAdapterService {
    private OrderService orderService = new OrderService();

    /**
     * 是否首单
     * @param uId
     * @return
     */
    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
