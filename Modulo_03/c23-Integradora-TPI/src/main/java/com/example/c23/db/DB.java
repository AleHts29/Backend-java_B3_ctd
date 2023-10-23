package com.example.c23.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/clase22";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    private static final String SQL_CREATE_TABLE_DOMICILIO = "DROP TABLE IF EXISTS DOMICILIOS; CREATE TABLE DOMICILIOS(" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "CALLE VARCHAR(100) NOT NULL," +
            "NUMERO INT NOT NULL," +
            "LOCALIDAD VARCHAR(100) NOT NULL," +
            "PROVINCIA VARCHAR(100) NOT NULL)";

    private static final String SQL_CREATE_TABLE_PACIENTE = "DROP TABLE IF EXISTS PACIENTES; CREATE TABLE PACIENTES(" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL,"+
            "DNI INT NOT NULL," +
            "FECHA DATE NOT NULL," +
            "DOMICILIO_ID INT NOT NULL," +
            "EMAIL VARCHAR(100) NOT NULL )";

    private static final String SQL_PACIENTE_01 = "INSERT INTO DOMICILIOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES('Amenabar', 832, 'CABA', 'BsAs');" +
            "INSERT INTO PACIENTES (APELLIDO, NOMBRE, DNI, FECHA, DOMICILIO_ID, EMAIL) VALUES('Huertas', 'Alejandro', 95198668, '2023-10-21', 1, 'alejo29h@gmail.com')";

    public static void crearDB() throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(SQL_CREATE_TABLE_DOMICILIO);
        statement.execute(SQL_CREATE_TABLE_PACIENTE);
        statement.execute(SQL_PACIENTE_01);
    }

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER, PASS);
    }

}
