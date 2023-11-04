package com.example.c41.repository;

import com.example.c41.model.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaqueteRepository extends MongoRepository<Paquete, Long> {
    Paquete findPaqueteByCodigo(String codigo);
}
