package org.example.service;

import org.example.dao.PacienteDaoH2;
import org.example.db.DB;
import org.example.model.Domicilio;
import org.example.model.Paciente;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    // El test no pasa porque falta la implementacion de paciente
    @Test
    public void savePatientsTest() throws Exception {
        DB.crearDB();
        //Given
        Domicilio domicilio = new Domicilio("Calle A23", 2341, "CABA", "BsAs");
        Paciente paciente = new Paciente("Alejandro","Huertas", 2342119, LocalDate.of(2023, 8, 15), domicilio);

        //Then
        pacienteService.save(paciente);

        //Assert
        assertTrue(paciente.getId()==1);

    }
}