package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;

public class Main {
    public static void main(String[] args) {

        // Preparar nuestra Coleccion de Perros
        List<Perro> canes = new ArrayList<>();
        canes.add(new Perro("Can_01", 3));
        canes.add(new Perro("Can_02", 4));
        canes.add(new Perro("Can_03", 3));

        // guardar la coleccion en un archivo
        ManejadorDeArchivos.guardar("outputFile.txt", canes );

        // recuperar la coleccion del archivo
        List<Perro> canesInFile = null;
        canesInFile = ManejadorDeArchivos.leer("outputFile.txt");

        for (Perro perro:canesInFile) {
            System.out.println(perro.toString());
        }
    }
}