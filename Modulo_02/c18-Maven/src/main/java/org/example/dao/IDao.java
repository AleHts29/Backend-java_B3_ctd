package org.example.dao;

import java.util.List;

public interface IDao <T>{
    T save(T t);
    T getById(Integer id);
    List<T> getAll();
}
