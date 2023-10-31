package com.c33.hibernate.service;

import com.c33.hibernate.entities.Profesor;
import com.c33.hibernate.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> obtenerProfesores(){
        return profesorRepository.findAll();
    }
}
