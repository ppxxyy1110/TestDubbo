package com.alibaba.dubbo.demo.conf;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
@MapperScan("com.alibaba.dubbo.demo.repository.mysql")
public class MscoreDataSourceConfig {
    static final String POPACKAGE = "com.midea.smart.ouer.entity";
    
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    @Bean(name = "mscoreDataSource")
    @Primary
    public DataSource mscoreDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "mscoreTransactionManager")
    @Primary
    public DataSourceTransactionManager rdsTransactionManager(@Qualifier("mscoreDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "mscoreSqlSessionFactory")
    @Primary
    public SqlSessionFactory rdsSqlSessionFactory(@Qualifier("mscoreDataSource") DataSource rdsDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rdsDataSource);
        sessionFactory.setTypeAliasesPackage(POPACKAGE);
        sessionFactory.setVfs(SpringBootVFS.class);
        return sessionFactory.getObject();
    }
    
}