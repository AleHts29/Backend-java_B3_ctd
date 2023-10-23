package org.example.model;

import java.time.LocalDate;

public class Paciente {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer dni;
    private LocalDate fecha;
    private Domicilio domicilio;


    public Paciente(Integer id, String nombre, String apellido, Integer dni, LocalDate fecha, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha = fecha;
        this.domicilio = domicilio;
    }

    public Paciente(String nombre, String apellido, Integer dni, LocalDate fecha, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha = fecha;
        this.domicilio = domicilio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
}
