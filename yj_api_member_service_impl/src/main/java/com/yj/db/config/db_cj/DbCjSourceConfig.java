package com.yj.db.config.db_cj;

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
@MapperScan(basePackages = "com.yj.cj.*.mapper",sqlSessionTemplateRef = "dbCjSqlSessionTemplate")
public class DbCjSourceConfig {
    @Bean("dbCjDataSource")
    @Primary
    public DataSource dbCjDataSource(DbCjConfig dbCjConfig) throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(dbCjConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(dbCjConfig.getPassword());
        mysqlXADataSource.setUser(dbCjConfig.getUser());

        AtomikosDataSourceBean xdDataSource = new AtomikosDataSourceBean();
        xdDataSource.setXaDataSource(mysqlXADataSource);
        xdDataSource.setUniqueResourceName(dbCjConfig.getUniqueResourceName());
        xdDataSource.setMaintenanceInterval(dbCjConfig.getMaintenanceInterval());
        xdDataSource.setMaxIdleTime(dbCjConfig.getMaxIdleTime());
        xdDataSource.setMaxLifetime(dbCjConfig.getMaxLifetime());
        xdDataSource.setMaxPoolSize(dbCjConfig.getMaxPoolSize());
        xdDataSource.setMinPoolSize(dbCjConfig.getMinPoolSize());
        xdDataSource.setTestQuery(dbCjConfig.getTestQuery());
        return xdDataSource;
    }

    @Bean("dbCjSqlSessionFactory")
    @Primary
    public SqlSessionFactory dbCjSqlSessionFactory(@Qualifier("dbCjDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:yj/cj/*/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Bean("dbCjSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate dbCjSqlSessionTemplate(@Qualifier("dbCjSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
