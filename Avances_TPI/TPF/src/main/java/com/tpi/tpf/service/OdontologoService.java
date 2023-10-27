package com.tpi.tpf.service;

import com.tpi.tpf.dao.IDao;
import com.tpi.tpf.dao.OdontologoDaoH2;
import com.tpi.tpf.model.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    @Autowired
    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    //guardar
    public Odontologo save(Odontologo odontologo){
        return odontologoIDao.save(odontologo);
    };

    //buascar
    public Odontologo getById(Integer id){
        return odontologoIDao.getById(id);
    };

    //buscarTodos
    public List<Odontologo> getAll(){
        return odontologoIDao.getAll();
    };
}
