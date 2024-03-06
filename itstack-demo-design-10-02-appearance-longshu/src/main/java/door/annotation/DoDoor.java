package door.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 切面注解定义
 *
 * @author yifeiwifelongshu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DoDoor {
    /**
     * 获取某个字段例如⽤户ID
     */
    String key() default "";

    /**
     * 确定白名单拦截后的具体返回内容
     */
    String returnJson() default "";
}
