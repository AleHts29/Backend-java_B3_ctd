package com.tpi.tpf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/clase23";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    private static final String URL_CREATE=URL+";INIT=RUNSCRIPT FROM 'create.sql'";

    public static void crearDB() throws Exception{
        Connection connection=null;
        try{
            Class.forName(DRIVER);
            connection=DriverManager.getConnection(URL_CREATE, USER, PASS);
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

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER, PASS);
    }

}
