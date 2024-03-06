package door.config;

import org.springframework.util.StringUtils;

/**
 * 配置服务类
 * 作用：为了获取配置信息
 * @author yifeiwifelongshu
 */
public class StarterService {
    /**
     * 用户字符串
     */
    private String userString;

    public StarterService(String userString) {
        this.userString = userString;
    }

    /**
     * 切割用户字符串
     * @param separatorChar
     * @return
     */
    public String[] spilt(String separatorChar){
        return StringUtils.split(this.userString, separatorChar);
    }
}
