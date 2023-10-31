package com.dh.c34.service;

import com.dh.c34.entities.Jugador;
import com.dh.c34.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    @Autowired
    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public Jugador guardarJugador(Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> getAllJudagores(){
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> getByName (String nombre){
        return jugadorRepository.getByName(nombre);
    }
}
