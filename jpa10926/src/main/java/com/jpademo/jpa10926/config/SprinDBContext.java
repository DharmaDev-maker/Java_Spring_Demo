package com.jpademo.jpa10926.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration 
@EnableTransactionManagement 
@ComponentScan("com.jpademo.jpa10926")
public class SprinDBContext {

    @Bean
    public DriverManagerDataSource getdataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/studentdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }   
    @Bean 
     public HibernateJpaVendorAdapter getjpaVendorAdapter() {
         HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
         adapter.setGenerateDdl(true);
         adapter.setShowSql(true);
         adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
         return adapter;
     }

     @Bean //managed parameters
     public LocalContainerEntityManagerFactoryBean getentityManagerFactory(
        DriverManagerDataSource dataSource,
        HibernateJpaVendorAdapter jpaVendorAdapter
     ) {
         LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
         factoryBean.setDataSource(dataSource);
         factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
         factoryBean.setPackagesToScan("com.jpademo.jpa10926.entites");
         return factoryBean;
     }

     @Bean("transactionManager")
public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
}



}
