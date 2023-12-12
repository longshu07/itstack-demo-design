package adapter.test;

import adapter.MqAdapter;
import adapter.dto.RebateInfo;
import adapter.service.OrderAdapterService;
import adapter.service.impl.InsideOrderAdapterServiceImpl;
import adapter.service.impl.POPOrderAdapterServiceImpl;
import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.mq.OrderMq;
import org.itstack.demo.design.mq.createAccountMq;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ApiTest {
    @Test
    public void testMqAdapter() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, ParseException {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = s.parse("2020-06-01 23:20:16");


        createAccountMq createAccountMq = new createAccountMq();
        createAccountMq.setNumber("100001");
        createAccountMq.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
        createAccountMq.setAccountDate(parse);
        createAccountMq.setDesc("在校开户");

        HashMap<String, Object> transformationMap01 = new HashMap<String, Object>();
        transformationMap01.put("userId", "number");
        transformationMap01.put("bizId", "number");
        transformationMap01.put("bizTime", "accountDate");
        transformationMap01.put("desc", "desc");
        RebateInfo rebateInfo01 = MqAdapter.convertToRebateInfo(createAccountMq.toString(), transformationMap01);
        System.out.println("mq.create_account(适配前)" + createAccountMq.toString());
        System.out.println("mq.create_account(适配后)" + JSON.toJSONString(rebateInfo01));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(parse);

        HashMap<String, Object> transformationMap02 = new HashMap<String, Object>();
        transformationMap02.put("userId", "uid");
        transformationMap02.put("bizId", "orderId");
        transformationMap02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MqAdapter.convertToRebateInfo(orderMq.toString(), transformationMap02);
        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));

    }

    /**
     * 接口适配
     */
    @Test
    public void testInterfaceAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderAdapterService = new InsideOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderAdapterService.isFirst("100001"));
    }

}
