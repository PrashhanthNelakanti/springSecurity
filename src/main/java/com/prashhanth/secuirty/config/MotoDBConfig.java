package com.prashhanth.secuirty.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "motoEntityManagerFactory",
        transactionManagerRef = "motoTransactionManager", basePackages = {
        "com.prashhanth.secuirty.repo.moto","com.prashhanth.secuirty.repo.student","com.prashhanth.secuirty.repo.laptop","com.prashhanth.secuirty.repo.roles"},considerNestedRepositories = true)
public class MotoDBConfig {

    @Bean(name = "motoDataSource")
    @ConfigurationProperties(prefix = "spring.moto.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "motoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean motoEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("motoDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("com.prashhanth.secuirty.entity").persistenceUnit("Moto")
                .persistenceUnit("Laptop").persistenceUnit("Student")
                        .build();
    }

    @Bean(name = "motoTransactionManager")
    public PlatformTransactionManager motoTransactionManager(
            @Qualifier("motoEntityManagerFactory") EntityManagerFactory motoEntityManagerFactory) {
        return new JpaTransactionManager(motoEntityManagerFactory);
    }
}