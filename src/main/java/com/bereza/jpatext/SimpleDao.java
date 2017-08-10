package com.bereza.jpatext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @author Igor Bereza
 */

@Repository
@Transactional
public class SimpleDao {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDao.class);

    @Autowired
    HibernateTemplate template;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Simple simple) {
        template.update(simple);
    }


    public Simple findById(Long id) {
        return template.get(Simple.class, id);
    }


    @PostConstruct
    @Transactional(readOnly = false)
    public void init() {

//        Simple simple = findById(1L);
//        logger.debug("simple is {} ", simple);
//        System.out.println("simple! " + simple.toString());
//
//        simple.setName("KAKA ");
//        update(simple);
    }

}
