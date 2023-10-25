package com.tpi.tpf.dao;

import com.tpi.tpf.db.DB;
import com.tpi.tpf.model.Domicilio;
import com.tpi.tpf.model.Paciente;

import java.sql.*;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?, ?, ?, ?)";
    private static final String SQL_SEARCH_X_ID="SELECT * FROM DOMICILIOS WHERE ID=?";

    @Override
    public Domicilio save(Domicilio domicilio) {
        Connection connection = null;
        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                domicilio.setId(rs.getInt(1));
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
        return domicilio;
    }

    @Override
    public Domicilio getById(Integer id) {
        Connection connection = null;
        Domicilio domicilio = null;
        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_X_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();


            while (rs.next()){
                domicilio = new Domicilio(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
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
        return domicilio;
    }

    @Override
    public Domicilio getByCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Domicilio> getAll() {
        return null;
    }

    @Override
    public Domicilio update(Domicilio domicilio) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
