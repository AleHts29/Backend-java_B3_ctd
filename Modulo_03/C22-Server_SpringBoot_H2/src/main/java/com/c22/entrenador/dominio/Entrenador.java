package com.c22.entrenador.dominio;

public class Entrenador {
    private Integer id;
    private String nombre;

    public Entrenador(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
