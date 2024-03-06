package door;

import com.alibaba.fastjson.JSON;
import door.annotation.DoDoor;
import door.config.StarterService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * 白名单切面逻辑
 *
 * @author yifeiwifelongshu
 */
@Aspect
@Component
public class DoJoinPoint {
    private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);
    @Autowired
    private StarterService starterService;

    /**
     * 定义切面，这里采用的是注解路径，也就是所有的加入这个注解的方法都会被切面进行管理。
     */
    @Pointcut("@annotation(door.annotation.DoDoor)")
    public void aopPoint() {
    }

    /**
     * 切面核心逻辑，这一部分主要是判断当前访问的用户ID是否白名单用户，如果是则放行jp.proceed();,否则返回自定义的拦截提示信息。
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint joinPoint) throws Throwable{
        //获取内容
        Method method = getMethod(joinPoint);
        // 获取注解
        DoDoor door = method.getAnnotation(DoDoor.class);

        // 获取字段值
        String keyValue = getFiledValue(door.key(), joinPoint.getArgs());
        logger.info("door handler method :{}, value{}", method.getName(), keyValue);
        // 如果为空，则直接执行
        if (StringUtils.isEmpty(keyValue)) {
            return joinPoint.proceed();
        }
        // 配置内容
        String[] split = starterService.spilt(",");
        // 白名单过滤，符合则执行
        for (String str : split) {
            if (keyValue.equals(str)) {
                return joinPoint.proceed();
            }
        }
        // 不在白名单内，则拦截
        return returnObject(door, method);



    }


    private Class<? extends Object> getClass(JoinPoint jp) throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature signature = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return getClass(jp).getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }



        /**
         * 返回拦截后的转换对象，也就是说当非白名单用户访问时则返回一些提示信息。
         * @param doGate DoDoor注解
         * @param method 方法
         * @return
         * @throws IllegalAccessException
         * @throws InstantiationException
         */
    private Object returnObject(DoDoor doGate, Method method) throws IllegalAccessException, InstantiationException{
        Class<?> returnType = method.getReturnType();
        String returnJson = doGate.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }


    /**
     * 获取指定key，也就是获取入参中的某个属性，这里主要是获取用户ID,通过ID进行拦截校验。
     *
     * @param filed 字段名称
     * @param args  参数
     * @return
     */
    private String getFiledValue(String filed, Object[] args) {
        String filedValue = null;
        for (Object arg : args) {
            try {
                if (null == filedValue || "".equals(filedValue)) {
                    filedValue = BeanUtils.getProperty(arg, filed);
                } else {
                    break;
                }
            } catch (Exception e) {
                if (args.length == 1) {
                    return args[0].toString();
                }
            }
        }
        return filedValue;
    }

}
