package com.c22.entrenador.dao;

import com.c22.entrenador.dominio.Entrenador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntrenadorDaoH2 implements IDao<Entrenador>{

    @Override
    public List<Entrenador> ListarTodos() {
        Connection connection = null;
        List<Entrenador> listaEntrenadores = new ArrayList<>();
        try{
            connection = DBH2.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM ENTRENADORES");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Entrenador entrenador = new Entrenador(rs.getInt(1), rs.getString(2));
                listaEntrenadores.add(entrenador);
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
        return listaEntrenadores;
    }
}
