package abstarct.factory.longshu.factory.adapter.impl;

import abstarct.factory.longshu.factory.adapter.ICacheAdapter;
import org.itstack.demo.design.matter.IIR;

import java.util.concurrent.TimeUnit;

/**
 * 集群2的缓存适配器实现类
 * 作用：在统⼀⽅法名下进⾏包装
 * @author yifeiwifelongshu
 */
public class IIRCacheAdapter implements ICacheAdapter {
    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
