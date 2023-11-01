package com.dh.tpi_v2.service;

import com.dh.tpi_v2.entites.Turno;
import com.dh.tpi_v2.repository.TurnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    //guardar
    public Turno save(Turno turno){
        return turnoRepository.save(turno);
    };

    //buascar
    public Optional<Turno> getById(Long id){
        return turnoRepository.findById(id);
    };

    //buscarTodos
    public List<Turno> getAll(){
        return turnoRepository.findAll();
    };

    //update
    public Turno updateAppointment(Turno turno){
        return turnoRepository.save(turno);
    }

    //Delete
    public void deleteById(Long id){
        turnoRepository.deleteById(id);
    }

}
