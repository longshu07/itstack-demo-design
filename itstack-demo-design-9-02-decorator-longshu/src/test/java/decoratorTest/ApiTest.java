package decoratorTest;

import decorator.LoginSsoDecorator;
import org.itstack.demo.design.SsoInterceptor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * ·这里测试了对装饰器模式的使用，通过透传原有单点登录类new SsoInterceptor(),传递给装
     * 饰器，让装饰器可以执行扩充的功能。
     * ·同时对于传递者和装饰器都可以是多组的，在一些实际的业务开发中，往往也是由于太多类型的子
     * 类实现而导致不易于维护，从而使用装饰器模式替代。
     *
     * ·结果符合预期，扩展了对方法拦截的校验性。
     * ·如果你在学习的过程中有用到过单点登陆，那么可以适当在里面进行扩展装饰器模式进行学习使
     * 用。
     * ·另外，还有一种场景也可以使用装饰器。例如；你之前使用某个实现某个接口接收单个消息，但由
     * 于外部的升级变为发送list集合消息，但你又不希望所有的代码类都去修改这部分逻辑。那么可
     * 以使用装饰器模式进行适配list集合，给使用者依然是for循环后的单个消息。
     */
    @Test
    public void testLoginSsoDecorator() {
        // 通过传入单点登录拦截类，进行默认的拦截请求处理，让装饰器可以执行扩充的功能。
        LoginSsoDecorator loginSsoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        String response = "response";
        String handle = "handle";
        boolean successFlag = loginSsoDecorator.preHandle(request, response, handle);
        logger.info("登录校验结果：{}", successFlag);
    }
}
