package com.softwarequalitycourse.lab2.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Created by sasha on 02.10.15.
 */
@Configuration
@EnableTransactionManagement
@PropertySource({"application.properties"})
@ComponentScan("com.softwarequalitycourse.lab2")
public class JavaConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        System.out.println(env.getProperty("jdbc.url"));
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }
//    @Bean
//    public SessionFactory sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setPackagesToScan(new String[]{"com.softwarequalitycourse.lab2.domain" });
//        sessionFactory.setHibernateProperties(hibernateProperties());
//        return sessionFactory.getObject();
//    }

//    @Bean
//    public SessionFactory sessionFactory() throws Exception {
//
//        AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.setAnnotatedPackages("com.softwarequalitycourse.lab2");
//        //sessionFactoryBean.setPackagesToScan(new String[]{"com.softwarequalitycourse.lab2.domain" });
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        sessionFactoryBean.afterPropertiesSet();
//        return sessionFactoryBean.getObject();
//    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        System.out.println("HibernateProperties");
        System.out.println(env.getProperty("hibernate.dialect"));
        System.out.println(env.getProperty("hibernate.show_sql"));
        System.out.println(env.getProperty("hibernate.format_sql"));

        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        return properties;
    }

//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory());
//        return txManager;
//    }
//@Bean
//public HibernateTransactionManager transactionManager(SessionFactory factory) {
//    return new HibernateTransactionManager(factory);
//}
//@Bean
//public SessionFactory sessionFactory() throws Exception {
//
//    AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
//    sessionFactoryBean.setDataSource(dataSource());
//    sessionFactoryBean.setPackagesToScan(new String[]{"com.softwarequalitycourse.lab2"});
//
//    Properties hibernateProperties = new Properties();
//    hibernateProperties.put("hibernate.show_sql", true);
//    hibernateProperties.put("persistenceUnitName", "jpaData");
//    hibernateProperties.put("hibernate.format_sql", false);
//    hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
//    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
//
//    sessionFactoryBean.setHibernateProperties(hibernateProperties);
//    sessionFactoryBean.afterPropertiesSet();
//
//    return sessionFactoryBean.getObject();
//}

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.softwarequalitycourse.lab2.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
//    @Bean
//    public HibernateTransactionManager transactionManager() throws Exception {
//
//        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
//
//        hibernateTransactionManager.setSessionFactory(sessionFactory());
//
//        return hibernateTransactionManager;
//    }
@Bean
@Autowired
public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(sessionFactory);

    return txManager;
}

//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
}
