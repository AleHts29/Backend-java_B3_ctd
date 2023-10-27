package com.tpi.tpf.service;

import com.tpi.tpf.dao.IDao;
import com.tpi.tpf.dao.PacienteDaoH2;
import com.tpi.tpf.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private IDao<Paciente> pacienteIDao;

    @Autowired
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
    public Paciente getByEmail(String email){
        return pacienteIDao.getByCriterio(email);
    };


    //buscarTodos
    public List<Paciente> getAll(){
        return pacienteIDao.getAll();
    };
}
