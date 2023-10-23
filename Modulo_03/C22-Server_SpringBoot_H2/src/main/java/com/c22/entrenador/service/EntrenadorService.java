package com.c22.entrenador.service;

import com.c22.entrenador.dao.EntrenadorDaoH2;
import com.c22.entrenador.dao.IDao;
import com.c22.entrenador.dominio.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorService implements IEntrenadorService {
    private IDao<Entrenador> entrenadorIDao;

    // constructor para inyectar la clase EntrenadorDaoH2() tambien se puede usar con @Autowired
    public EntrenadorService() {
        entrenadorIDao = new EntrenadorDaoH2();
    }


    @Override
    public List<Entrenador> listarEntrenadores() {

        return entrenadorIDao.ListarTodos();
    }
}
