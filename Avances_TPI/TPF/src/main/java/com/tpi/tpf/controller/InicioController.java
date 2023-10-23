package com.tpi.tpf.controller;

import com.tpi.tpf.model.Odontologo;
import com.tpi.tpf.model.Paciente;
import com.tpi.tpf.service.OdontologoService;
import com.tpi.tpf.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/index")
public class InicioController {
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public InicioController(PacienteService pacienteService, OdontologoService odontologoService) {
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;

    }

    @GetMapping
    public String getTestData(Model model, @RequestParam("email") String email,  @RequestParam("id") Integer id){
        Paciente paciente = pacienteService.getByEmail(email);
        Odontologo odontologo = odontologoService.getById(id);

        //El Model se usa para pasar la info a la plantilla .html
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());
        model.addAttribute("matricula", odontologo.getMatricula());

        return "index";
    }
}
