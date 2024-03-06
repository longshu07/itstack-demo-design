package door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置类注解定义
 * ⽤于定义好后续在 application.yml 中添加 itstack.door 的配置信息
 * @author yifeiwifelongshu
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }


}
