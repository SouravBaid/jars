package com.Joker.core;

import java.util.Properties;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;
import org.apache.tomcat.jdbc.pool.DataSource;

public class TomCatDataSouceFactory extends UnpooledDataSourceFactory {

	private DataSource dataSource = null;

	public TomCatDataSouceFactory() {

		this.dataSource = new DataSource();

	}

	public void setProperties(Properties properties) {
		this.dataSource.setPassword(properties.getProperty("password"));
		this.dataSource.setUsername(properties.getProperty("user"));
		this.dataSource.setUrl(properties.getProperty("url"));
		this.dataSource.setJmxEnabled(true);
		this.dataSource.setTestWhileIdle(false);
		this.dataSource.setTestOnBorrow(true);
		this.dataSource.setValidationQuery("SELECT 1");
		this.dataSource.setTestOnReturn(false);
		this.dataSource.setValidationInterval(30000);
		this.dataSource.setTimeBetweenEvictionRunsMillis(30000);
		this.dataSource.setMaxActive(200);
		this.dataSource.setInitialSize(20);
		this.dataSource.setMaxWait(10000);
		this.dataSource.setRemoveAbandonedTimeout(60);
		this.dataSource.setMinEvictableIdleTimeMillis(30000);
		this.dataSource.setMinIdle(10);
		this.dataSource.setLogAbandoned(true);
		this.dataSource.setRemoveAbandoned(true);
		try {
			this.dataSource.setDriverClassName(properties.getProperty("driver"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public DataSource getDataSource() {
		return (this.dataSource);
	}

}
