package com.yj.db.config.db_core;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.yj.core.*.mapper",sqlSessionTemplateRef = "dbCoreSqlSessionTemplate")
public class DbCoreSourceConfig {

    @Bean("dbCoreDataSource")
    @Primary
    public DataSource dbCoreDataSource(DbCoreConfig dbCoreConfig) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dbCoreConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(dbCoreConfig.getPassword());
        mysqlXADataSource.setUser(dbCoreConfig.getUser());

        AtomikosDataSourceBean xdDataSource = new AtomikosDataSourceBean();
        xdDataSource.setXaDataSource(mysqlXADataSource);
        xdDataSource.setUniqueResourceName(dbCoreConfig.getUniqueResourceName());
        xdDataSource.setMaintenanceInterval(dbCoreConfig.getMaintenanceInterval());
        xdDataSource.setMaxIdleTime(dbCoreConfig.getMaxIdleTime());
        xdDataSource.setMaxLifetime(dbCoreConfig.getMaxLifetime());
        xdDataSource.setMaxPoolSize(dbCoreConfig.getMaxPoolSize());
        xdDataSource.setMinPoolSize(dbCoreConfig.getMinPoolSize());
        xdDataSource.setTestQuery(dbCoreConfig.getTestQuery());
        return xdDataSource;
    }

    @Bean("dbCoreSqlSessionFactory")
    @Primary
    public SqlSessionFactory dbCoreSqlSessionFactory(@Qualifier("dbCoreDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:yj/core/*/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean("dbCoreSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate dbCoreSqlSessionTemplate(@Qualifier("dbCoreSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

