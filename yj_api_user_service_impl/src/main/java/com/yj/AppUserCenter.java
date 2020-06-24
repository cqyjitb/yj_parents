package com.yj;

import com.yj.config.DbCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({DbCoreConfig.class})
public class AppUserCenter {

    public static void main(String[] args) {
        SpringApplication.run(AppUserCenter.class,args);
    }
}
