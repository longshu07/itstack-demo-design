package singleton;

/**
 * 懒汉式-线程安全-在方法上添加锁
 * @author longshu
 */
public class Singleton_02_lazy_safe_thread_method {
    private static Singleton_02_lazy_safe_thread_method instance;
    private Singleton_02_lazy_safe_thread_method(){}

    /**
     * synchronized锁住方法
     * @return
     */
    public static synchronized Singleton_02_lazy_safe_thread_method getInstance(){
        if (instance == null) {
            instance = new Singleton_02_lazy_safe_thread_method();
        }
        return instance;
    }
}
