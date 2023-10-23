package com.c22.entrenador.dao;

import java.util.List;

public interface IDao<T> {
    List<T> ListarTodos();
}
