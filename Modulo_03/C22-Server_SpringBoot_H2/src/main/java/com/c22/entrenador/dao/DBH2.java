package com.c22.entrenador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBH2 {
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase22", "sa", "sa");
    }

    public static void cargarDB(){
        Connection connection = null;
        try{
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clase22;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
    }
}
