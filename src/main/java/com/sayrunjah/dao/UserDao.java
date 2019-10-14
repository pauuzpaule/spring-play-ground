package com.sayrunjah.dao;

import com.sayrunjah.Model.User;
import com.sayrunjah.lib.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.sayrunjah.lib.HibernateUtil.getSessionFactory;

@Component
public class UserDao {

    private Session session = null;
    public UserDao() {
        session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
    }

    public void createUser(User user) {

        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public void updateUser(int id, User user) {
        User userData = find(id);
        userData.merge(user);
        session.update(userData);
        session.getTransaction().commit();
        session.close();
    }

    public User find(int id) {
        return (User) session.get(User.class, id);
    }

    public List<User> list() {
        return (List<User>) session.createCriteria(User.class).list();
    }

    public void closeSession() {
        session.close();
    }

    public void details() {

    }

}
