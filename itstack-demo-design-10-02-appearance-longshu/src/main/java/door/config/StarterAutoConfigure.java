package door.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置类信息获取
 * 作用：是对配置的获取操作，主要是对注解的定义
 *  @author yifeiwifelongshu
 */
@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {

    @Autowired
    private StarterServiceProperties starterServiceProperties;

    /**
     * @ConditionalOnMissingBean： 如果没有指定的Bean，条件生效
     * ConditionalOnProperty： 如果有指定的配置，条件生效
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "itstack.door", value = "enabled", havingValue = "true")
    public StarterService starterService(){
        return new StarterService(starterServiceProperties.getUserStr());
    }


}
