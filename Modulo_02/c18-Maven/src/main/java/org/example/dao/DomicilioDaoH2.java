package org.example.dao;
import org.example.db.DB;
import org.example.model.Domicilio;

import java.sql.*;
import java.util.List;

public class DomicilioDaoH2 implements IDao<Domicilio> {
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?, ?, ?, ?)";

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

        return null;
    }

    @Override
    public Domicilio getById(Integer id) {
        return null;
    }

    @Override
    public List<Domicilio> getAll() {
        return null;
    }
}
