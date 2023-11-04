package com.example.c41.service;

import com.example.c41.exception.BadRequestException;
import com.example.c41.model.Paquete;
import com.example.c41.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {


    private final PaqueteRepository paqueteRepository;

    @Autowired
    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    //Agregar
    public Paquete addPaquete(Paquete paquete) throws BadRequestException{
        if(paqueteRepository.findPaqueteByCodigo(paquete.getCodigo())!=null){
            throw new BadRequestException("Ya existe un paquete con el codigo: "+paquete.getCodigo());
        }
        //si el distinto de null, deberia ser un error
        if(paquete.getDestino()!=null){
            return paqueteRepository.save(paquete);
        }else{
            throw new BadRequestException("El paquete debe contar con un destino");
        }
    }

    //Listar
    public List<Paquete> listPaquete(){
        return paqueteRepository.findAll();
    }

}
