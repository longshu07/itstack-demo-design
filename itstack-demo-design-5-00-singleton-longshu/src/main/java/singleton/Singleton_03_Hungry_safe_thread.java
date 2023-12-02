package singleton;

/**
 * 饿汉模式-线程安全
 * 此种⽅式与我们开头的第⼀个实例化 Map 基本⼀致，在程序启动的时候直接运⾏加载，后续有外部需要使⽤的时候获取即可。
 * 那么这种⽅式导致的问题就像你下载个游戏软件，可能你游戏地图还没有打开呢，但是程序已经将这些地图全部实例化。到你⼿机上最明显体验就⼀开游戏内存满了，
 * @author longshu
 */
public class Singleton_03_Hungry_safe_thread {
    /**
     * 在程序启动的时候直接运⾏加载，后续有外部需要使⽤的时候获取即可。
     */
    private static Singleton_03_Hungry_safe_thread instance = new Singleton_03_Hungry_safe_thread();
    private Singleton_03_Hungry_safe_thread(){

    }
    public Singleton_03_Hungry_safe_thread getInstance(){
        return instance;
    }
}
