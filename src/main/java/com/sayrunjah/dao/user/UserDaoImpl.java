package com.sayrunjah.dao.user;

import com.sayrunjah.Model.User;
import com.sayrunjah.dao.ObjectDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class UserDaoImpl implements ObjectDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void add(Object object) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(object);
        logger.info("Person saved successfully, Person Details="+object);
    }

    @Override
    public void update(Object object) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<?> list(Object object) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> personsList = session.createQuery("FROM users").list();
        for(User p : personsList){
            logger.info("Person List::"+p);
        }
        return personsList;
    }

    @Override
    public void remove(int id) {

    }
}
