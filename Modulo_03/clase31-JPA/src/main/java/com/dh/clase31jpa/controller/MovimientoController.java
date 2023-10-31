package com.dh.clase31jpa.controller;

import com.dh.clase31jpa.entities.Movimiento;
import com.dh.clase31jpa.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {
    private final MovimientoService movimientoService;

    @Autowired
    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> consultarMovimiento(){
        return ResponseEntity.ok(movimientoService.listAll());
    }

    @PostMapping
    public ResponseEntity<Movimiento> createMovimiento(@RequestBody Movimiento movimiento){
        return ResponseEntity.ok(movimientoService.save(movimiento));
    }
}
