package decorator;

import org.itstack.demo.design.HandlerInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 具体登录逻辑扩展装饰类
 * ·在具体的装饰类实现中，继承了装饰类SsoDecorator,那么现在就可以扩展方法：preHandle
 * ·在preHandle的实现中可以看到，这里只关心扩展部分的功能，同时不会影响原有类的核心服
 * 务，也不会因为使用继承方式而导致的多余子类，增加了整体的灵活性。
 * @author longshulongshu
 */
public class LoginSsoDecorator extends SsoDecorator{

    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);
    /**
     * 模拟校验操作
     */
    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();
    static {
        authMap.put("huahua", "queryUserInfo");
        authMap.put("doudou", "queryUserInfo");
    }
    /**
     * 构建函数注入 抽象构件角色(Component)-抽象接口HandlerInterceptor
     * @param handlerInterceptor
     */
    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    /**
     * 覆盖了方法 preHandle，由handlerInterceptor具体实现preHandle方法
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(String request, String response, Object handler) {
        // 获取父类中的前置处理
        boolean success = super.preHandle(request, response, handler);
        if (!success){
            return false;
        }
        /*
         * 扩展处理其他校验操作
         */
        String userId = request.substring(8);
        String method = authMap.get(userId);
        logger.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        // 模拟方法校验
        return "queryUserInfo".equals(method);
    }

}
