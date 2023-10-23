package com.example.c23.service;
import com.example.c23.dao.IDao;
import com.example.c23.dao.PacienteDaoH2;
import com.example.c23.model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    public PacienteService() {
        this.pacienteIDao = new PacienteDaoH2();
    }

    //guardar
    public Paciente save(Paciente paciente){
        return pacienteIDao.save(paciente);
    };

    //buascar
    public Paciente getById(Integer id){
        return pacienteIDao.getById(id);
    };
    public Paciente getByEmail(String email){
        return pacienteIDao.getByCriterio(email);
    };


    //buscarTodos
    public List<Paciente> getAll(){
        return pacienteIDao.getAll();
    };
}
