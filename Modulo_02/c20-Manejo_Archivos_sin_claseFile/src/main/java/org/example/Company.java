package org.example;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String cuit;
    private String razonSocial;
    private List<Employee> employees;

    public Company(String cuit, String razonSocial) {
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        employees = new ArrayList<>();
    }

    public void listAllEmployee(){
        for (Employee employee:employees) {
            System.out.println(employee.toString());
        }
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
