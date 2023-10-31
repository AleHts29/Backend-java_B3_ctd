package com.dh.c34.service;

import com.dh.c34.entities.Jugador;
import com.dh.c34.entities.Tecnico;
import com.dh.c34.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    public final TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public Tecnico guardarTecnico(Tecnico tecnico){
        return tecnicoRepository.save(tecnico);
    }

    public List<Tecnico> getAllTecnicos(){
        return tecnicoRepository.findAll();
    }

    public Optional<Tecnico> getByName(String nombre){
        return tecnicoRepository.getByName(nombre);
    }
}
