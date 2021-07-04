/*
package com.prashhanth.secuirty.config.relations;

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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "relEntityManagerFactory",
        transactionManagerRef = "relTransactionManager", basePackages = {
        "com.prashhanth.secuirty.repo.moto"})
public class StudentLaptop {

    @Bean(name = "relDataSource")
    @ConfigurationProperties(prefix = "spring.moto.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "relEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean motoEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("relDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("com.prashhanth.secuirty.entity.moto").persistenceUnit("Moto","")
                .build();
    }

    @Bean(name = "relTransactionManager")
    public PlatformTransactionManager relTransactionManager(
            @Qualifier("relEntityManagerFactory") EntityManagerFactory relEntityManagerFactory) {
        return new JpaTransactionManager(relEntityManagerFactory);
    }
}
*/
