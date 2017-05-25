package com.makas.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersistenceConfig {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	@Primary //tell SB this is the default DS if there are many datasources
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	@Bean
	@ConfigurationProperties(prefix="datasource.flyway")
	@FlywayDataSource
	public DataSource flywaydataSource() {
		return DataSourceBuilder.create().build();
	}
}
