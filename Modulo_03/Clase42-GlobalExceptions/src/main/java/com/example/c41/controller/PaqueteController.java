package com.example.c41.controller;

import com.example.c41.exception.BadRequestException;
import com.example.c41.model.Paquete;
import com.example.c41.service.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {
    public PaqueteService paqueteService;

    @Autowired
    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @GetMapping
    public ResponseEntity<List<Paquete>> buscarPaquete(){
        return ResponseEntity.ok(paqueteService.listPaquete());
    }

    @PostMapping
    public ResponseEntity<Paquete> buscarPaquete(@RequestBody Paquete paquete) throws BadRequestException {
        return ResponseEntity.ok(paqueteService.addPaquete(paquete));
    }
}
