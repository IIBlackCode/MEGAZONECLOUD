package com.megazone.www.DataSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.apache.shardingsphere.sharding.algorithm.keygen.SnowflakeKeyGenerateAlgorithm;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = "com.megazone.www.Mapper", sqlSessionTemplateRef = "sqlSessionTemplate")
public class DataSourceConfig {

	@Primary
	@Bean(name = "ds0DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.ds0")
	public DataSource ds0DataSource() {
		System.out.println("[ds0]"+DataSourceBuilder.create().toString());
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "ds1DataSource")
	@ConfigurationProperties(prefix = "spring.datasource.ds1")
	public DataSource ds1DataSource() {
		System.out.println("[ds1]"+DataSourceBuilder.create().toString());
		return DataSourceBuilder.create().build();
	}
	
	Map<String, DataSource> createDataSourceMap() {
		Map<String, DataSource> result = new HashMap<>();
		result.put("ds0", ds0DataSource());
		result.put("ds1", ds1DataSource());
		return result;
	}
	
	@Bean
    @ConfigurationProperties(prefix = "your.sharding.datasource") // Adjust prefix accordingly
    public DataSource shardingDataSource() throws SQLException {
        return ShardingSphereDataSourceFactory.createDataSource(createDataSourceMap(), Collections.singleton(createShardingRuleConfiguration()), new Properties());
	}

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(shardingDataSource());
    }

    private ShardingRuleConfiguration createShardingRuleConfiguration() {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        // 필요에 따라 Sharding 규칙 구성
        // 예시: shardingRuleConfig.getTableRuleConfigs().add(createTableRuleConfiguration());
        return shardingRuleConfig;
    }
    
    private ShardingTableRuleConfiguration createTableRuleConfiguration() {
    	ShardingTableRuleConfiguration tableRuleConfig = new ShardingTableRuleConfiguration("your_table_logic_name", "ds${0..1}.your_table_actual_name");
        // 필요에 따라 다른 테이블 규칙 설정
        return tableRuleConfig;
    }
}
