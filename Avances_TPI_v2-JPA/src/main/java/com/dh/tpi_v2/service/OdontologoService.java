package com.dh.tpi_v2.service;


import com.dh.tpi_v2.entites.Odontologo;
import com.dh.tpi_v2.repository.Odontologorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
   private final Odontologorepository odontologorepository;

   @Autowired
    public OdontologoService(Odontologorepository odontologorepository) {
        this.odontologorepository = odontologorepository;
    }

    //guardar
    public Odontologo save(Odontologo odontologo){
        return odontologorepository.save(odontologo);
    };

   //update
    public Odontologo update(Odontologo odontologo){
        return odontologorepository.save(odontologo);
    };


    //buascar
    public Optional<Odontologo> getById(Long id){
        return odontologorepository.findById(id);
    };

    //buscarTodos
    public List<Odontologo> getAll(){
        return odontologorepository.findAll();
    };

    //eliminar
    public void delete(Long id){
        odontologorepository.deleteById(id);
    }
}
