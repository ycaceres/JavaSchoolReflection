package com.nearsoft.javaschool.database;

import java.util.List;

/**
 * Created by ycaceres on 10/4/17.
 */
public interface DatabaseActions<T> {
    void save(T object) throws InterruptedException;
    void delete(T object);
    void update(T object);
    List<T> getAll();
}
