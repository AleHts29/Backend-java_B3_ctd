package com.dh.tpi_v2.service;

import com.dh.tpi_v2.dto.TurnoDTO;
import com.dh.tpi_v2.entites.Odontologo;
import com.dh.tpi_v2.entites.Paciente;
import com.dh.tpi_v2.entites.Turno;
import com.dh.tpi_v2.exceptions.ResourceNotFoundException;
import com.dh.tpi_v2.repository.TurnoRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;

    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    //guardar
    public TurnoDTO save(TurnoDTO turno){
        //Necesitamos una entidad para guardar la data relacionando Ids y fecha
        Paciente paciente = new Paciente();
        Odontologo odontologo = new Odontologo();
        Turno turnoEntity = new Turno();

        //tengo un DTO complejo y necesito pasarlo a una entidad
        paciente.setId(turno.getPaciente_id());
        odontologo.setId(turno.getOdontologo_id());
        turnoEntity.setFecha(turno.getFecha());
        turnoEntity.setPaciente(paciente);
        turnoEntity.setOdontologo(odontologo);

        Turno saveTurno = turnoRepository.save(turnoEntity);

        //Finalmente devuelvo un DTO
        //Opcion A
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(saveTurno.getId());
        turnoDTO.setOdontologo_id(saveTurno.getOdontologo().getId());
        turnoDTO.setPaciente_id(saveTurno.getPaciente().getId());
        turnoDTO.setFecha(saveTurno.getFecha());
        return turnoDTO;

        //Opcion B
//        turno.setId(saveTurno.getId());
//        return turno;
    };

    //buascar
    public Optional<TurnoDTO> getById(Long id){
        Optional<Turno> turnoBuscado = turnoRepository.findById(id); //Retorna una entidad turno
        Optional<TurnoDTO> turnoDTOBuscado = Optional.empty(); // el Optional.empty() me habilita a poder retornar un Optional con el DTO
        if(turnoBuscado.isPresent()){
            TurnoDTO turnoDTOReturn = new TurnoDTO();
            turnoDTOReturn.setId(turnoBuscado.get().getId());
            turnoDTOReturn.setPaciente_id(turnoBuscado.get().getPaciente().getId());
            turnoDTOReturn.setOdontologo_id(turnoBuscado.get().getOdontologo().getId());
            turnoDTOReturn.setFecha(turnoBuscado.get().getFecha());
            turnoDTOBuscado=Optional.of(turnoDTOReturn);
        }
        return turnoDTOBuscado;
    };

    //buscarTodos
    public List<Turno> getAll(){
        return turnoRepository.findAll();
    };

    //update
    public Turno updateAppointment(Turno turno){
        return turnoRepository.save(turno);
    }

    //Delete
    public void deleteById(Long id) throws ResourceNotFoundException {
        // Si no existe el truno - lanzamos la Excepción
        Optional<TurnoDTO> turnoDTO = getById(id);
        if(turnoDTO.isPresent()){
            turnoRepository.deleteById(id);
        }else {
            throw new ResourceNotFoundException("No existe el id del turno ingresado - id:"+id);
        }

    }

}
