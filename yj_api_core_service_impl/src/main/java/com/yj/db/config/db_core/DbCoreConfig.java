package com.yj.db.config.db_core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.dbcore")
@Data
public class DbCoreConfig {
    private String url;
    private String user;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private int minIdleTime;
    private String testQuery;
    private String uniqueResourceName;
}
