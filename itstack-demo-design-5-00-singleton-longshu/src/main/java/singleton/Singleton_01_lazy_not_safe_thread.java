package singleton;

/**
 * 懒汉式-线程不安全
 * 此种⽅式的单例确实满⾜了懒加载，但是如果有多个访问者同时去获取对象实例你，就会造成多个同样的实例并存，从⽽没有达到单例的要求
 * @author longshu
 */
public class Singleton_01_lazy_not_safe_thread {
    private static Singleton_01_lazy_not_safe_thread instance;

    private Singleton_01_lazy_not_safe_thread(){
    }

    public static Singleton_01_lazy_not_safe_thread getInstance(){
        if (instance == null) {
            instance = new Singleton_01_lazy_not_safe_thread();
        }
        return instance;
    }
}
