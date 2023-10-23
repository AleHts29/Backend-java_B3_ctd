package com.tpi.tpf.dao;

import java.util.List;

public interface IDao <T>{
    T save(T t);
    T getById(Integer id);
    T getByCriterio(String criterio);
    List<T> getAll();
}
