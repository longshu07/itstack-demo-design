package abstarct.factory.longshu.factory.proxy;

import abstarct.factory.longshu.factory.adapter.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 抽象⼯程代理类
 *主要的作⽤：完成代理类，同时对于使⽤哪个集群有外部通过⼊参进⾏传递
 * @author yifeiwifelongshu
 */
public class JDKProxy {
    /**
     * 返回一个代理对象
     * @param interfaceClass
     * @param iCacheAdapter
     * @param <T>
     * @return
     * @throws Exception
     */
    public static<T> T getProxy(Class<T> interfaceClass, ICacheAdapter iCacheAdapter) throws Exception{
        InvocationHandler invocationHandler = new JDKInvocationHandler(iCacheAdapter);
        // 获取当前线程的类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // 获取对应的接口信息
        Class<?>[] classes = interfaceClass.getInterfaces();
        // 返回一个代理对象
        return (T) Proxy.newProxyInstance(classLoader, new Class[]{classes[0]}, invocationHandler);
    }


}
