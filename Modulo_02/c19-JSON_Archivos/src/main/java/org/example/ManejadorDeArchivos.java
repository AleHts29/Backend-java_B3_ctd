package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManejadorDeArchivos {

    public static void guardar(String nombreArchivo, List<Perro> canes){
        // guardar la coleccion en un archivo
        try {
            FileOutputStream fos = new FileOutputStream(nombreArchivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(canes);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Perro> leer(String nombreArchivo){
        List<Perro> canesInFile = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            canesInFile = (ArrayList)objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return canesInFile;
    }
}
