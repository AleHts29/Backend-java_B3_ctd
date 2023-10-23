package org.example;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("20-3241123-3", "CoffeeCoder");
        company.addEmployee(new Employee("Alejandro", "Huertas", 1234, 12000.0));
        company.listAllEmployee();

        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Empleados.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            for (Employee employee:company.getEmployees()) {
                //guardar cada employee con su formato correspondiente
                String linea =
                        employee.getNombre()+";"+
                        employee.getApellido()+";"+
                        employee.getLegajo()+";"+
                        employee.getSueldo()+"\n";
                bufferedOutputStream.write((linea.getBytes()));
            }
            bufferedOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}