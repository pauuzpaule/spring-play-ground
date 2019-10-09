package com.sayrunjah.dao;

import java.util.List;

public interface ObjectService {
    public void add(Object object);
    public void update(Object object);
    public List<?> list(Object object);
    public void remove(int id);
}
