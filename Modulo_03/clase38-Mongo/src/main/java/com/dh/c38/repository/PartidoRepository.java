package com.dh.c38.repository;

import com.dh.c38.model.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends MongoRepository<Partido, Long> {
}
