package abstarct.factory.longshu.factory.adapter.impl;

import abstarct.factory.longshu.factory.adapter.ICacheAdapter;
import org.itstack.demo.design.matter.EGM;

import java.util.concurrent.TimeUnit;

/**
 * 集群1的缓存适配器实现类
 * 作用：在统⼀⽅法名下进⾏包装
 * @author  longshu
 */
public class EGMCacheAdapter implements ICacheAdapter {
    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
