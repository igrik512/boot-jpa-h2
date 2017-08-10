package com.bereza.jpatext;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;

@SpringBootApplication
@EnableTransactionManagement
public class JpaTextApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(JpaTextApplication.class);


    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        SpringApplication.run(JpaTextApplication.class, args);

//        ApplicationContext context = new AnnotationConfigApplicationContext(JpaTextApplication.class);
//
//        context.getBean(SimpleDao.class).findById(1L);


    }


    @Bean
    @Autowired
    SessionFactory factory(EntityManagerFactory entityManagerFactory) {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory;
    }


/*    @Bean
    EntityManagerFactory entityManagerFactory() {
        LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean;
        localEntityManagerFactoryBean.setPersistenceUnitName("persistence.xml");
        localEntityManagerFactoryBean.afterPropertiesSet();
        return localEntityManagerFactoryBean.getObject();
    }*/

    @Bean
    @Autowired
    HibernateTemplate template(SessionFactory sessionFactory) {
        HibernateTemplate hibernateTemplate = new HibernateTemplate();
        hibernateTemplate.setSessionFactory(sessionFactory);

        hibernateTemplate.afterPropertiesSet();
        return hibernateTemplate;
    }


    @Autowired
    SimpleDao dao;

    @Transactional
    @Override
    public void run(String... strings) throws Exception {

        Simple s = dao.findById(1L);


        logger.debug("stext {} ", s);

        Simple simple = new Simple();
        simple.setId(1L);
        simple.setName("SUPER NAME");
        dao.update(simple);
    }
}
