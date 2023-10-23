package com.example.c23.dao;


import com.example.c23.db.DB;
import com.example.c23.model.Domicilio;
import com.example.c23.model.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente>{
    private static  final String SQL_INSERT="INSERT INTO PACIENTES(APELLIDO, NOMBRE, DNI, FECHA, DOMICILIO_ID, EMAIL) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_SEARCH_X_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=?";

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
            ps.setInt(3, paciente.getDni());
            ps.setDate(4, Date.valueOf(paciente.getFecha()));
            ps.setInt(5, (paciente.getDomicilio()).getId());
            ps.setString(6, paciente.getEmail());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Paciente getById(Integer id) {
        return null;
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
                domicilio = domicilioDaoH2.getById(rs.getInt(6));
                paciente = new Paciente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5).toLocalDate(),
                        domicilio,
                        rs.getString(7)
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
        return null;
    }
}
