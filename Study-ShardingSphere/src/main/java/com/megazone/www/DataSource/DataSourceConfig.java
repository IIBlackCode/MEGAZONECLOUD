package com.megazone.www.DataSource;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

@Configuration
@MapperScan(basePackages = "com.megazone.www.Mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

    @Primary
    @Bean(name = "ds0DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds0")
    public DataSource ds0DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ds1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource ds1DataSource() {
        return DataSourceBuilder.create().build();
    }
    
}
