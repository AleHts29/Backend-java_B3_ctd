package com.dh.tpi_v2.controller;

import com.dh.tpi_v2.entites.Turno;
import com.dh.tpi_v2.service.OdontologoService;
import com.dh.tpi_v2.service.PacienteService;
import com.dh.tpi_v2.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }


    @PostMapping
    public ResponseEntity<Turno> registerAppointment(@RequestBody Turno turno){
        ResponseEntity<Turno> responseEntity;
        //cuando esta mal
        if(odontologoService.getById(turno.getOdontologo().getId()).isPresent() && pacienteService.getById(turno.getPaciente().getId()).isPresent()){
            responseEntity = ResponseEntity.ok(turnoService.save(turno));
        }else {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return responseEntity;
    }


    @GetMapping
    public ResponseEntity<List<Turno>>  getAllAppointments(){
        return ResponseEntity.ok(turnoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> getByIdAppointment(@PathVariable Long id){
        Optional<Turno> turno = turnoService.getById(id);
        if(turno.isPresent()){
            return  ResponseEntity.ok(turno.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id){
        Optional<Turno> turno = turnoService.getById(id);
        if(turno.isPresent()){
            turnoService.deleteById(id);
            return  ResponseEntity.ok("Se elimino el Turno de ID: "+id);

        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<Turno> apdateAppointment(@RequestBody Turno turno){
        ResponseEntity<Turno> responseEntity;
        if(turnoService.getById(turno.getId()).isPresent()){
            if(
                    odontologoService.getById(turno.getOdontologo().getId()).isPresent() && pacienteService.getById(turno.getPaciente().getId()).isPresent()
            ){
                responseEntity = ResponseEntity.ok(turnoService.updateAppointment(turno));
            }else {
                responseEntity = ResponseEntity.badRequest().build();
            }
        }else {
            responseEntity = ResponseEntity.badRequest().build();
        }

        return responseEntity;
    }

}
