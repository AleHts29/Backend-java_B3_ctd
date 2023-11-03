package com.dh.c38.controller;

import com.dh.c38.model.Partido;
import com.dh.c38.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    @Autowired
    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }


    @PostMapping
    public ResponseEntity<Partido> createPartido(@RequestBody Partido partido){
        return ResponseEntity.ok(partidoService.createPartido(partido));
    }

    @GetMapping
    public List<Partido> ListPartido(){
        return partidoService.getAllPartidos();
    }


}
