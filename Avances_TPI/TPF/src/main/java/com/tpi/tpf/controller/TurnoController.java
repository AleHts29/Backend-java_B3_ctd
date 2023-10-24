package com.tpi.tpf.controller;

import com.tpi.tpf.model.Odontologo;
import com.tpi.tpf.model.Turno;
import com.tpi.tpf.service.OdontologoService;
import com.tpi.tpf.service.PacienteService;
import com.tpi.tpf.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if(odontologoService.getById(turno.getOdontologo().getId())==null|| pacienteService.getById(turno.getPaciente().getId())==null){
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else {
            //cuando esta ok
            responseEntity = ResponseEntity.ok(turnoService.save(turno));
        }
        return responseEntity;
    }


    @GetMapping
    public List<Turno> getAllAppointments(){
        return turnoService.getAll();
    }
}
