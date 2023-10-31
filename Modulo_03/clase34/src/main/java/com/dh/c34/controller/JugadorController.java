package com.dh.c34.controller;

import com.dh.c34.entities.Jugador;
import com.dh.c34.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    private final JugadorService jugadorService;

    @Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public ResponseEntity<List<Jugador>> getJugadores(){
        return ResponseEntity.ok(jugadorService.getAllJudagores());
    }

    @PostMapping
    public ResponseEntity<Jugador> createJugador(@RequestBody Jugador jugador){
        return ResponseEntity.ok(jugadorService.guardarJugador(jugador));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Jugador> getByName(@PathVariable String name){
        Optional<Jugador> jugadorByName = jugadorService.getByName(name);
        if(jugadorByName.isPresent()){
            return ResponseEntity.ok(jugadorByName.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
}
