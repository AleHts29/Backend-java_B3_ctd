package com.dh.tpi_v2.controller;

import com.dh.tpi_v2.dto.TurnoDTO;
import com.dh.tpi_v2.entites.Domicilio;
import com.dh.tpi_v2.entites.Odontologo;
import com.dh.tpi_v2.entites.Paciente;
import com.dh.tpi_v2.service.OdontologoService;
import com.dh.tpi_v2.service.PacienteService;
import com.dh.tpi_v2.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class TurnoControllerTest {
    @Autowired
    private MockMvc mockMvc;


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

        //Given
        TurnoDTO turno = new TurnoDTO();
        turno.setFecha(LocalDate.of(2023, 12,20));
        turno.setOdontologo_id(1l);
        turno.setPaciente_id(1l);

        //Then
        TurnoDTO turnoDTO = turnoService.save(turno);

    }

    @Test
    public void getAllAppointments() throws Exception {
        //Cargamos informacion
        this.precargarData();

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        assertFalse(result.getResponse().getContentAsString().isEmpty());
    }

}