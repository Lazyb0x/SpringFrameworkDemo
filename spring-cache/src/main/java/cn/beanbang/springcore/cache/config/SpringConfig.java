package cn.beanbang.springcore.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.beanbang.springcore.cache")
@EnableCaching  // 启用缓存
public class SpringConfig {

    // 声明缓存管理器
    @Bean
    public CacheManager cacheManager(){
        return new ConcurrentMapCacheManager();
    }

}
