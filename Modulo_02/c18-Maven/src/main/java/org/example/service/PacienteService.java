package org.example.service;



import org.example.dao.IDao;
import org.example.model.Paciente;

import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    //guardar
    public Paciente save(Paciente paciente){
        return pacienteIDao.save(paciente);
    };

    //buascar
    public Paciente getById(Integer id){
        return pacienteIDao.getById(id);
    };


    //buscarTodos
    public List<Paciente> getAll(){
        return pacienteIDao.getAll();
    };
}
