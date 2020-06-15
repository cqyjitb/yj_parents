package com.yj;

import com.yj.db.config.db_core.DbCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableScheduling
@EnableConfigurationProperties({DbCoreConfig.class})
public class AppCore {

    public static void main(String[] args){
        SpringApplication.run(AppCore.class,args);
    }
}
