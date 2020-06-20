package com.yj;

import com.yj.db.config.db_core.DbCoreConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
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
public class AppCore implements CommandLineRunner {
    private final static Logger logger= LoggerFactory.getLogger(AppCore.class);
    public static void main(String[] args){
        SpringApplication.run(AppCore.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("=========hello World========");
    }
}
