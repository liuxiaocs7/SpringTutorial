package com.liuxiaocs.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan(basePackages = "com.liuxiaocs.mybatis")
@MapperScan(basePackages = "com.liuxiaocs.mybatis")
public class MyBatisAutoConfiguration {

    @Autowired
    private MyBatisProperties myBatisProperties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        // dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // dataSource.setUrl("jdbc:mysql://localhost:3306/suns?serverTimezone=GMT%2B8");
        // dataSource.setUsername("root");
        // dataSource.setPassword("lx123456");
        dataSource.setDriverClassName(myBatisProperties.getDriverClassName());
        dataSource.setUrl(myBatisProperties.getUrl());
        dataSource.setUsername(myBatisProperties.getUsername());
        dataSource.setPassword(myBatisProperties.getPassword());
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // sqlSessionFactoryBean.setTypeAliasesPackage("com.liuxiaocs.mybatis");
        sqlSessionFactoryBean.setTypeAliasesPackage(myBatisProperties.getTypeAliasesPackages());
        // 需要一个Resource类型的参数
        // sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("UserDAOMapper.xml"));
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            // Resource[] resources = resolver.getResources("com.liuxiaocs.mapper/*Mapper.xml");
            Resource[] resources = resolver.getResources(myBatisProperties.getMapperLocations());
            sqlSessionFactoryBean.setMapperLocations(resources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSessionFactoryBean;
    }
}
