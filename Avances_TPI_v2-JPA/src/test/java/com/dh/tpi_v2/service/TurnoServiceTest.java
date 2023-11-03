package com.dh.tpi_v2.service;

import com.dh.tpi_v2.dto.TurnoDTO;
import com.dh.tpi_v2.entites.Domicilio;
import com.dh.tpi_v2.entites.Odontologo;
import com.dh.tpi_v2.entites.Paciente;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class TurnoServiceTest {
    //Creamos un paciente, turno y un odontologo
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;



    public  void precargarData(){
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle x");
        domicilio.setNumero(123);
        domicilio.setLocalidad("CABA");
        domicilio.setProvincia("BsAs");

        Paciente paciente = new Paciente();
        paciente.setNombre("Alejandro");
        paciente.setApellido("Huertas");
        paciente.setDomicilio(domicilio);
        pacienteService.save(paciente);

        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Odontologo_name");
        odontologo.setApellido("Odontologo_lastName");
        odontologo.setMatricula("M123");
        odontologoService.save(odontologo);

    }

    @Test
    @Order(1)
    void save() {
        precargarData();
        //Given
        TurnoDTO turno = new TurnoDTO();
        turno.setFecha(LocalDate.of(2023, 12,20));
        turno.setOdontologo_id(1l);
        turno.setPaciente_id(1l);

        //Then
        TurnoDTO turnoDTO = turnoService.save(turno);

        //Assert
        assertEquals(1, turnoDTO.getId());
    }

    @Test
    @Order(2)
    void getById() {
        //Given
        Optional<TurnoDTO> turnoDTO = turnoService.getById(1l);

        //Then
        TurnoDTO turnoDTO1 = turnoDTO.get();

        //Assert
        assertNotNull(turnoDTO1);
    }

    @Test
    void getAll() {
    }

    @Test
    void updateAppointment() {
    }

    @Test
    void deleteById() {
    }
}