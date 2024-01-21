package decorator;

import org.itstack.demo.design.HandlerInterceptor;

/**
 * 装饰角色(Decorator)-定义抽象类并继承接口中的方法，保证一致性
 * ·在装饰类中有两个重点的地方是：1)继承了处理接口、2)提供了构造函数、3)覆盖了方法 preHandle。
 * 以上三个点是装饰器模式的核心处理部分，这样可以踢掉对子类继承的方式实现逻辑功能扩展。
 * @author longshulongshu
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    /**
     * 抽象构件角色(Component)-抽象接口，用于接受具体实现接口
     */
    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator() {
    }

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
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
        return this.handlerInterceptor.preHandle(request, response, handler);
    }
}
