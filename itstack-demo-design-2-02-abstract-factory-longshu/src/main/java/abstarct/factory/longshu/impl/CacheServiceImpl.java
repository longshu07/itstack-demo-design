package abstarct.factory.longshu.impl;

import abstarct.factory.longshu.ICacheService;
import org.itstack.demo.design.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * 业务代码最开始的原有的缓存实现
 *
 * @author  longshu
 */
public class CacheServiceImpl implements ICacheService {
    /**
     * 注入最开始的单实例redis操作类
     */
    private final RedisUtils redisUtils = new RedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
