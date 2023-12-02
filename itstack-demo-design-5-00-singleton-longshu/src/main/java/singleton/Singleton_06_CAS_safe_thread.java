package singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * cas-线程安全
 * 1、java并发库提供了很多原⼦类来⽀持并发访问的数据安全
 * 性； AtomicInteger 、 AtomicBoolean 、 AtomicLong 、 AtomicReference 。
 * 可以封装引⽤⼀个V实例，⽀持并发访问如上的单例⽅式就是使⽤了这样的⼀个
 * 特点。
 *2、使⽤CAS的好处就是不需要使⽤传统的加锁⽅式保证线程安全，⽽是依赖于CAS的忙等算法，依赖
 * 于底层硬件的实现，来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞也就没有了额外
 * 的开销，并且可以⽀持较⼤的并发性。
 * 3、当然CAS也有⼀个缺点就是忙等，如果⼀直没有获取到将会处于死循环中。
 * @author longshu
 */
public class Singleton_06_CAS_safe_thread {
    private Singleton_06_CAS_safe_thread(){}

    /**
     * 原⼦类来⽀持并发访问的数据安全性；
     * AtomicInteger 、 AtomicBoolean 、 AtomicLong 、 AtomicReference
     * 可以封装引⽤⼀个V实例，⽀持并发访问如上的单例⽅式就是使⽤了这样的⼀个
     */
    private static AtomicReference<Singleton_06_CAS_safe_thread> instance = new AtomicReference<>();

    public static Singleton_06_CAS_safe_thread getInstance(){
        Singleton_06_CAS_safe_thread singletonInstance = instance.get();
        if (singletonInstance == null) {
            // 如果null值，则设置新值
            instance.compareAndSet(null, new Singleton_06_CAS_safe_thread());
            singletonInstance = instance.get();
        }
        return singletonInstance;
    }

    public static void main(String[] args) {
        System.out.println("one:"  + Singleton_06_CAS_safe_thread.getInstance());
        System.out.println("two:" + Singleton_06_CAS_safe_thread.getInstance());
    }
}
