package com.dh.c34.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tecnicos")
public class Tecnico {
    @Id
    @SequenceGenerator(name = "tecnico_sequence", sequenceName = "tecnico_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tecnico_sequence")
    private Long id;
    private String nombre;
    private Integer edad;
    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private Set<Jugador> jugadores = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
