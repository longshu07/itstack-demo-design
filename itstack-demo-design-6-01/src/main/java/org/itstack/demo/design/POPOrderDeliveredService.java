package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.mq.POPOrderDeliveredMq;

public class POPOrderDeliveredService {

    public void onMessage(String message) {

        POPOrderDeliveredMq mq = JSON.parseObject(message, POPOrderDeliveredMq.class);

        mq.getuId();
        mq.getOrderId();
        mq.getOrderTime();

        // ... 处理自己的业务
    }

}
