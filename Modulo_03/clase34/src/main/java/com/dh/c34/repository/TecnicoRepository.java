package com.dh.c34.repository;

import com.dh.c34.entities.Jugador;
import com.dh.c34.entities.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

    //para obtener un jugador por nombre, usamos una query
    @Query("select t from Tecnico t where t.nombre=?1")
    Optional<Tecnico> getByName(String nombreTecnico);
}
