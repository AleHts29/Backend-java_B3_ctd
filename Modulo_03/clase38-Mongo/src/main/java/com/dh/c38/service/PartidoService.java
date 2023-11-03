package com.dh.c38.service;

import com.dh.c38.model.Partido;
import com.dh.c38.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    @Autowired
    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido createPartido(Partido partido){
        return partidoRepository.save(partido);
    }

    public List<Partido> getAllPartidos(){
        return partidoRepository.findAll();
    }
}
