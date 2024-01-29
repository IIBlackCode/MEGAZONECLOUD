package com.megazone.www.DataSource;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShardingConfig {

    @Bean
    public DataSource dataSource(DataSource ds0DataSource, DataSource ds1DataSource) throws SQLException {
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        // 여기에 Sharding 알고리즘 및 규칙을 추가
        
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds0", ds0DataSource);
        dataSourceMap.put("ds1", ds1DataSource);
        
        Properties properties = new Properties();
        // 기타 Sharding 관련 설정을 여기에 추가
        
        // YAML 관련 설정을 무시하도록 하기 위해 아래 코드 추가
        properties.setProperty("yaml.config.skip", "true");
        return ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singletonList(shardingRuleConfig), properties);
    }
}