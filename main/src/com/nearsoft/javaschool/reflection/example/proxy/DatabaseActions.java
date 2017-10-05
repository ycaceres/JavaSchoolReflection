package com.nearsoft.javaschool.reflection.example.proxy;

import java.util.List;

/**
 * Created by ycaceres on 10/4/17.
 */
public interface DatabaseActions<T> {
    void save(T object);
    void delete(T object);
    void update(T object);
    List<T> getAll();
}
