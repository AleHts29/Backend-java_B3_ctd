package com.dh.tpi_v2.service;

import com.dh.tpi_v2.entites.Paciente;
import com.dh.tpi_v2.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;


    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //guardar
    public Paciente save(Paciente paciente){
        return pacienteRepository.save(paciente);
    };

    //buascar
    public Optional<Paciente> getById(Long id){
        return pacienteRepository.findById(id);
    };
    public Optional<Paciente> getByEmail(String email){
        return pacienteRepository.getByCriterio(email);
    };


    //buscarTodos
    public List<Paciente> getAll(){
        return pacienteRepository.findAll();
    };
}
