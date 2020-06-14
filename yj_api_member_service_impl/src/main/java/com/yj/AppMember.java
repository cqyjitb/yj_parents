package com.yj;

import com.yj.db.config.db_cj.DbCjConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableScheduling
@EnableConfigurationProperties({DbCjConfig.class})
public class AppMember {

    public static void main(String[] args){
        SpringApplication.run(AppMember.class,args);
    }
}
