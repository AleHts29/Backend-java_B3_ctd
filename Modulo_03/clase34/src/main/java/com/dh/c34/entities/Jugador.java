package com.dh.c34.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @SequenceGenerator(name = "jugador_sequence", sequenceName = "jugador_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugador_sequence")
    private Long id;
    private String nombre;
    private String clubFavorito;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;

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

    public String getClubFavorito() {
        return clubFavorito;
    }

    public void setClubFavorito(String clubFavorito) {
        this.clubFavorito = clubFavorito;
    }
}
