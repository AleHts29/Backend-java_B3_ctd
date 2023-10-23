package com.c22.entrenador.controller;

import com.c22.entrenador.dominio.Entrenador;
import com.c22.entrenador.service.IEntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    private final IEntrenadorService entrenadorService;

    @Autowired
    public EntrenadorController(IEntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> getEntrenador(){
        return entrenadorService.listarEntrenadores();
    }

}
