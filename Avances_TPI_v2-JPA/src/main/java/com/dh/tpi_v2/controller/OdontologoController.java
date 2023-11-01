package com.dh.tpi_v2.controller;


import com.dh.tpi_v2.entites.Odontologo;
import com.dh.tpi_v2.service.OdontologoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Odontologo> getDentisById(@PathVariable Long id){
        Optional<Odontologo> odontologo = odontologoService.getById(id);
        if(odontologo.isPresent()){
            return ResponseEntity.ok(odontologo.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDentis(@PathVariable Long id){
        Optional<Odontologo> odontologo = odontologoService.getById(id);
        if(odontologo.isPresent()){
            odontologoService.delete(id);
            return ResponseEntity.ok("Se elimino al odontologo con id="+id);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se pudo eliminar el recurso");
        }
    }

    @PutMapping
    public ResponseEntity<Odontologo> updateDentis(@RequestBody Odontologo odontologo){
        Optional<Odontologo> odontologoById = odontologoService.getById(odontologo.getId());
        if(odontologoById.isPresent()){
            Odontologo updateDentis = odontologoService.update(odontologo);
            return ResponseEntity.ok(updateDentis);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
