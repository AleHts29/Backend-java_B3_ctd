package com.dh.clase31jpa.service;

import com.dh.clase31jpa.entities.Movimiento;
import com.dh.clase31jpa.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    private final MovimientoRepository movimientoRepository;

    @Autowired
    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }


    public List<Movimiento> listAll(){
        return movimientoRepository.findAll();
    }

    public Movimiento save(Movimiento movimiento){
        return movimientoRepository.save(movimiento);
    }
}
