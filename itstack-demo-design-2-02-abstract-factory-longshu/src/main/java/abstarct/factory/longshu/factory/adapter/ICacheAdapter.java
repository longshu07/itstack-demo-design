package abstarct.factory.longshu.factory.adapter;

import java.util.concurrent.TimeUnit;

/**
 * 缓存适配器接口。
 * 主要作⽤：是让所有集群的提供⽅，能在统⼀的⽅法名称下进⾏操作
 *
 * @author  longshu
 */
public interface ICacheAdapter {
    String get(String key);

    void set(String key, String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
