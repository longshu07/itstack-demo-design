package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.mq.createAccountMq;

public class create_accountMqService {

    public void onMessage(String message) {

        createAccountMq mq = JSON.parseObject(message, createAccountMq.class);

        mq.getNumber();
        mq.getAccountDate();

        // ... 处理自己的业务
    }

}
