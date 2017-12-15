/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.sp3;

import java.util.Objects;
import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 *
 * @author �Ʒ��� <fanghua.tang@daydaycook.com>
 */
@Configuration
@ComponentScan(basePackages = "demo.sp3.service")
@EnableJpaRepositories(basePackages = "demo.sp3.repository")
public class SpringConfig {

    @Bean
    public DataSource ds() {
        BasicDataSource ret = new BasicDataSource();
//        ret.setUrl("jdbc:mysql://rm-bp14981igf6tctwcjo.mysql.rds.aliyuncs.com:3306/daydaycook?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
//        ret.setUsername("root");
//        ret.setPassword("1qaz@WSX");
        ret.setUrl("jdbc:mysql://localhost:3306/sp3?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true");
        ret.setUsername("root");
        ret.setPassword("123456");
        return ret;
    }

    @Bean
    @Inject
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabase(Database.MYSQL);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("demo.sp3.model");
        factory.setDataSource(ds);
        return factory;
    }

    @Bean
    @Inject
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        Objects.requireNonNull(emf);
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
}
