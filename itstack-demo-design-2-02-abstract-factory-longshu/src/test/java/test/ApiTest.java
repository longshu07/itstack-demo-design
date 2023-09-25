package test;

import abstarct.factory.longshu.ICacheService;
import abstarct.factory.longshu.factory.adapter.ICacheAdapter;
import abstarct.factory.longshu.factory.adapter.impl.EGMCacheAdapter;
import abstarct.factory.longshu.factory.proxy.JDKProxy;
import abstarct.factory.longshu.impl.CacheServiceImpl;
import org.junit.Test;

public class ApiTest {
    @Test
    public void String() throws Exception {
        ICacheService iCacheServiceProxyEGM =  JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        iCacheServiceProxyEGM.set("user_name_01", "longshu");
        String val01 = iCacheServiceProxyEGM.get("user_name_01");
        System.out.println("测试结果：" + val01);

    }
}
