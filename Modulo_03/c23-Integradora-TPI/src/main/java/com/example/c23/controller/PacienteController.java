package com.example.c23.controller;

import com.example.c23.model.Paciente;
import com.example.c23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController // --> Se usa cuando tenemos Apis
@Controller // --> Se usa cuando el renderizado es en una plantilla .html
@RequestMapping("/api")
public class PacienteController {
    private final PacienteService pacienteService;

   @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/paciente")
    public String traerPaciente(Model model, @RequestParam("email") String email){
        Paciente paciente = pacienteService.getByEmail(email);

        //El Model se usa para pasar la info a la plantilla .html
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "index";
    }

}
