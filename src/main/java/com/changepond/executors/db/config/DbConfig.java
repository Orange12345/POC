package com.changepond.executors.db.config;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef="changepondDbEntityManagerFactory",transactionManagerRef="changepondDbTransactionManager",
basePackages={"com.changepond.executors.db.repository"})
public class DbConfig {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Bean(name="changepondDbDataSource")
	@Primary
	public DataSource dataSource()
	{
		BasicDataSource simpleDriverDataSource=new BasicDataSource();
		simpleDriverDataSource.setUrl(url);
		simpleDriverDataSource.setUsername(userName);
		simpleDriverDataSource.setPassword(password);
		return simpleDriverDataSource;
	}
	
	@Bean(name = "changepondDbEntityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("changepondDbDataSource")DataSource dataSource)
	{
		return builder.dataSource(dataSource).packages("com.changepond.executors.db.model")
				.persistenceUnit("changepondPersistanceUnit").properties(jpaProperties()).build();
	}
	
	@Bean(name ="changepondDbTransactionManager")
	@Primary
	public PlatformTransactionManager transactionManager(@Qualifier("changepondDbEntityManagerFactory")
	EntityManagerFactory entityManagerFactory)
	{
		return new JpaTransactionManager(entityManagerFactory);
	}
	private Map<String, String> jpaProperties() {
		Map<String, String> jpaPropertiesMap = new HashMap<>();
		jpaPropertiesMap.put("show.sql", "True");
		return jpaPropertiesMap;
	}
}