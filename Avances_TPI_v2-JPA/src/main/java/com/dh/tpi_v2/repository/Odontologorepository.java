package com.dh.tpi_v2.repository;

import com.dh.tpi_v2.entites.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Odontologorepository extends JpaRepository<Odontologo, Long> {
}
