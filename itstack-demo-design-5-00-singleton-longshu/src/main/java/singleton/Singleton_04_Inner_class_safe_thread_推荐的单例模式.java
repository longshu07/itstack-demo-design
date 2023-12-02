package singleton;

/**
 * 使用类的内部类-线程安全
 * 1、使⽤类的静态内部类实现的单例模式，既保证了线程安全有保证了懒加载，同时不会因为加锁的⽅式耗费性能。
 * 2、这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，也就是⼀个类的构造⽅法在多线程环境下可以被正确的加载
 * 3、此种⽅式也是⾮常推荐使⽤的⼀种单例模式
 * @author longshu
 */
public class Singleton_04_Inner_class_safe_thread_推荐的单例模式 {
    private Singleton_04_Inner_class_safe_thread_推荐的单例模式(){}

    /**
     * 内部类
     */
    private static class SingletonHolder{
        private static Singleton_04_Inner_class_safe_thread_推荐的单例模式 instance = new Singleton_04_Inner_class_safe_thread_推荐的单例模式();
    }
    public static Singleton_04_Inner_class_safe_thread_推荐的单例模式 getInstance(){
        return SingletonHolder.instance;
    }
}
