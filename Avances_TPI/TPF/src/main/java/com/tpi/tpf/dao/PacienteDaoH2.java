package com.tpi.tpf.dao;

import com.tpi.tpf.db.DB;
import com.tpi.tpf.model.Domicilio;
import com.tpi.tpf.model.Paciente;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteDaoH2 implements IDao<Paciente>{
    private static  final String SQL_INSERT="INSERT INTO PACIENTES(APELLIDO, NOMBRE, EMAIL, DNI, FECHA, DOMICILIO_ID) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_SEARCH_X_ID="SELECT * FROM PACIENTES WHERE ID=?";
    private static final String SQL_SEARCH_X_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";
    private static final String SQL_SEARCH_ALL="SELECT * FROM PACIENTES";

    @Override
    public Paciente save(Paciente paciente) {
        Connection connection = null;
        try{
        //Primero se debe guardar el domicilio del paciente que vienen cuando se carga la informacion del paciente
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            domicilioDaoH2.save(paciente.getDomicilio());

            connection = DB.getConnection();
            PreparedStatement ps =  connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getApellido());
            ps.setString(2, paciente.getNombre());
            ps.setString(3, paciente.getEmail());
            ps.setInt(4, paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFecha()));
            ps.setInt(6, (paciente.getDomicilio()).getId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente getById(Integer id) {
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio;
        try{
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_X_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            while (rs.next()){
                //Obtenemos de 'rs' la FK (DOMICILIO_ID)
                domicilio = domicilioDaoH2.getById(rs.getInt(7));
                paciente = new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilio
                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public Paciente getByCriterio(String criterio) {
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio;
        try{
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_X_EMAIL);
            ps.setString(1, criterio);
            ResultSet rs = ps.executeQuery();

            //Encontramos al paciente desde la DB, pero ademas debemos devolverlo con el domicilio.
            while (rs.next()){
                //Obtenemos de 'rs' la FK (DOMICILIO_ID)
                domicilio = domicilioDaoH2.getById(rs.getInt(7));
                paciente = new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilio

                );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return paciente;
    }

    @Override
    public List<Paciente> getAll() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        Domicilio domicilio;
        try{
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_ALL);
            ResultSet rs = ps.executeQuery();



            while (rs.next()){
               domicilio = domicilioDaoH2.getById(rs.getInt(7));
                System.out.println("--->  " + rs.getInt(7));
                System.out.println(domicilio);
                pacientes.add(new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDate(6).toLocalDate(),
                        domicilio));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        return pacientes;
    }

    @Override
    public Paciente update(Paciente paciente) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
