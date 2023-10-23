package dao;

import java.util.ArrayList;

public interface IDao <T> {
    T save(T t);
    T search(Integer id);
}
