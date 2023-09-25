package abstarct.factory.longshu;

import java.util.concurrent.TimeUnit;

/**
 * 缓存通用接口
 * @author yifeiwifelongshu
 */
public interface ICacheService {
    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
