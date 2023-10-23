package com.tpi.tpf.dao;

import com.tpi.tpf.db.DB;
import com.tpi.tpf.model.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo>{

    private static  final String SQL_INSERT="INSERT INTO ODONTOLOGOS(APELLIDO, NOMBRE, MATRICULA) VALUES(?, ?, ?)";
    private static final String SQL_SEARCH_X_ID="SELECT * FROM ODONTOLOGOS WHERE ID=?";
    private static final String SQL_SEARCH_ALL="SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo save(Odontologo odontologo) {
        Connection connection = null;
        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, odontologo.getApellido());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getMatricula());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                odontologo.setId(rs.getInt(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }catch (SQLException sqlExp){
                sqlExp.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public Odontologo getById(Integer id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_X_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                odontologo = new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
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
        return odontologo;
    }

    @Override
    public Odontologo getByCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Odontologo> getAll() {
        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();

        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                odontologos.add(new Odontologo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                        ));
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
        return odontologos;
    }
}
