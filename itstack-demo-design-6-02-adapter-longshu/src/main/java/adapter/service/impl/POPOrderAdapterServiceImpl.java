package adapter.service.impl;

import adapter.service.OrderAdapterService;
import org.itstack.demo.design.service.POPOrderService;

/**
 * 外部订单适配器实现类
 * @author longshu
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private POPOrderService popOrderService = new POPOrderService();

    /**
     * 是否首单
     *
     * @param uId
     * @return
     */
    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
