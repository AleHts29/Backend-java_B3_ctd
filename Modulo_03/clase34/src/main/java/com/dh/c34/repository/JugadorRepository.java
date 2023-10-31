package com.dh.c34.repository;

import com.dh.c34.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    //para crear un nuevo jugador, usamos save

    //para listar todos, usamos findAll

    //para obtener un jugador por nombre, usamos una query
    @Query("select j from Jugador j where j.nombre=?1")
    Optional<Jugador> getByName(String nombreJugador);
}
