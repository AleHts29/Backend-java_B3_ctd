package com.tpi.tpf.controller;

import com.tpi.tpf.model.Odontologo;
import com.tpi.tpf.model.Paciente;
import com.tpi.tpf.service.OdontologoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private final OdontologoService odontologoService;


    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public List<Odontologo> getAllDentist(){
        return odontologoService.getAll();
    }

    @PostMapping
    public Odontologo addDentist(@RequestBody Odontologo odontologo){
        return odontologoService.save(odontologo);
    }

    @GetMapping("/{id}")
    public Odontologo getByIDPatients(@PathVariable Integer id){
        return odontologoService.getById(id);
    }
}
