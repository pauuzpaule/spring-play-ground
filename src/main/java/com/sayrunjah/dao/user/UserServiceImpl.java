package com.sayrunjah.dao.user;

import com.sayrunjah.dao.ObjectDao;
import com.sayrunjah.dao.ObjectService;

import javax.transaction.Transactional;
import java.util.List;

public class UserServiceImpl implements ObjectService {

    private ObjectDao objectDao;

    public void setUserDAO(ObjectDao objectDao) {
        this.objectDao = objectDao;
    }

    @Transactional
    @Override
    public void add(Object object) {
        this.objectDao.add(object);
    }

    @Override
    public void update(Object object) {

    }

    @Override
    public List<?> list(Object object) {
        return this.objectDao.list(object);
    }

    @Override
    public void remove(int id) {

    }
}
