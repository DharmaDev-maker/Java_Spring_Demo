package com.practice.student_mange.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import jakarta.persistence.EntityManagerFactory;

@Configuration //what config in short: It is a Spring annotation that indicates this class contains Spring bean definitions and configuration.
@EnableTransactionManagement    
@ComponentScan(basePackages = "com.practice.student_mange")
@PropertySource("classpath:application.properties")
public class SpringDbCOntext {

     @Bean
    public DriverManagerDataSource getdataSource(
        @Value("${spring.datasource.url}") String url,
        @Value("${spring.datasource.username}") String username,
        @Value("${spring.datasource.password}") String password) {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("org.postgresql.Driver");
    dataSource.setUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    return dataSource;
} 
    @Bean 
     public HibernateJpaVendorAdapter getjpaVendorAdapter() {
         HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
         adapter.setGenerateDdl(true);
         adapter.setShowSql(false);
         adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
         return adapter;
     }

     @Bean
public LocalContainerEntityManagerFactoryBean getentityManagerFactory(
        DriverManagerDataSource dataSource,
        HibernateJpaVendorAdapter jpaVendorAdapter) {

    LocalContainerEntityManagerFactoryBean factoryBean =
            new LocalContainerEntityManagerFactoryBean();

    factoryBean.setDataSource(dataSource);
    factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
    factoryBean.setPackagesToScan("com.practice.student_mange.Entity");

    Properties props = new Properties();
    props.put("hibernate.hbm2ddl.auto", "update");

    factoryBean.setJpaProperties(props);

    return factoryBean;
}
@Bean("transactionManager")
public JpaTransactionManager getTransactionManager(
        EntityManagerFactory entityManagerFactory) {

    JpaTransactionManager transactionManager =
            new JpaTransactionManager();

    transactionManager.setEntityManagerFactory(entityManagerFactory);

    return transactionManager;
}



}
