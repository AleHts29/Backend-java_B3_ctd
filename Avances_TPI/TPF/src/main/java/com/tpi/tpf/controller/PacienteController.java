package com.tpi.tpf.controller;

import com.tpi.tpf.model.Paciente;
import com.tpi.tpf.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public Paciente getByIDPatients(@PathVariable Integer id){
        return pacienteService.getById(id);
    }

}
