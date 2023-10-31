package com.dh.tpi_v2.controller;


import com.dh.tpi_v2.entites.Paciente;
import com.dh.tpi_v2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController // --> Se usa cuando tenemos Apis
//@Controller // --> Se usa cuando el renderizado es en una plantilla .html
@RequestMapping("/pacientes")
public class PacienteController {

private  final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente addPatients(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @GetMapping
    public List<Paciente> getAllPatients(){
        return pacienteService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getByIDPatients(@PathVariable Long id){
        Optional<Paciente> paciente = pacienteService.getById(id);
        if(paciente.isPresent()){
           return ResponseEntity.ok(paciente.get());
        }else {
           return ResponseEntity.notFound().build();
        }

    }

}
