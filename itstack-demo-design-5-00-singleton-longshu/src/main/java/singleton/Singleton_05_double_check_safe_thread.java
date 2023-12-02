package singleton;

/**
 * 双重校验锁-线程安全
 * 1、⽅式是⽅法级锁的优化，减少了部分获取实例的耗时。
 * 2、同时这种⽅式也满⾜了懒加载
 * 注意volatile关键字
 * @author longshu
 */
public class Singleton_05_double_check_safe_thread {
    /**
     * volatile关键字
     * instance声明为volatile之后，告诉JVM编译器不允许指令重排优化，告诉CPU不允许乱序执行。
     * 防止 instance = new Singleton_05_double_check(); // part3这一步的重排序
     */
    private static volatile Singleton_05_double_check_safe_thread instance;

    /**
     * 私有化构造器，防止外部调用
     */
    private Singleton_05_double_check_safe_thread(){

    }
    public static Singleton_05_double_check_safe_thread getInstance(){
        // 在多线程的环境下,当一个线程执行getInstance()时，
        // 程序到达part 1处的 if (instance == null) 先判断单例对象是否已经初始化，
        // 如果已经初始化，就直接返回单例对象，如果未初始化，则进入后续同步块逻辑；
        if (instance == null) { // part 1
            synchronized(Singleton_05_double_check_safe_thread.class) {
                /*
                 程序进入同步块，当一个线程获得锁之后，进行判空(part2处的instance=nu11)、对象创建、获得返回值的操作，其他的线程必须等待其完成，才能继续执行。
                 */
                if (instance == null) { // part 2
                    instance = new Singleton_05_double_check_safe_thread(); // part3
                }
            }
        }
        return instance;
    }
}
