package org.example;

public class Employee {
    private String nombre;
    private String apellido;
    private Integer legajo;
    private Double sueldo;

    public Employee(String nombre, String apellido, Integer legajo, Double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo=" + legajo +
                ", sueldo=" + sueldo +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
}
