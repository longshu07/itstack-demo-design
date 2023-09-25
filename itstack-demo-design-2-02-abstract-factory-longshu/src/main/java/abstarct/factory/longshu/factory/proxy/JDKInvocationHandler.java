package abstarct.factory.longshu.factory.proxy;

import abstarct.factory.longshu.factory.adapter.ICacheAdapter;
import abstarct.factory.longshu.util.ClassLoaderUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 在代理类的实现中，通过穿透进来的集群服务进⾏⽅法操作。
 * 另外在 invoke 中通过使⽤获取⽅法名称反射⽅式，调⽤对应的⽅法功能，也就简化了整体的使
 * ⽤
 * @author yifeiwifelongshu
 */
public class JDKInvocationHandler implements InvocationHandler {

    private Logger logger = LoggerFactory.getLogger(JDKInvocationHandler.class);
    private ICacheAdapter iCacheAdapter;
    /**
     * Processes a method invocation on a proxy instance and returns
     * the result.  This method will be invoked on an invocation handler
     * when a method is invoked on a proxy instance that it is
     * associated with.
     * 处理代理实例上的方法调用并返回结果。
     * 当在与其关联的代理实例上调用方法时，将在调用处理程序上调用此方法。
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("method:{}", method);
        logger.info("args:{}", args);
        logger.info("ClassLoaderUtils.getClazzByArgs(args):{}", ClassLoaderUtils.getClazzByArgs(args));
        return ICacheAdapter.class.getMethod(method.getName(), ClassLoaderUtils.getClazzByArgs(args)).invoke(iCacheAdapter, args);
    }

    public JDKInvocationHandler(ICacheAdapter iCacheAdapter) {
        this.iCacheAdapter = iCacheAdapter;
    }
}
