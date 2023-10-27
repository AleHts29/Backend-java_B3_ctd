package com.tpi.tpf.service;

import com.tpi.tpf.model.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;

    @Test
    void getById() {
        Integer idPaciente = 1;
       Paciente paciente = pacienteService.getById(idPaciente);
       assertNotNull(paciente);
    }
}