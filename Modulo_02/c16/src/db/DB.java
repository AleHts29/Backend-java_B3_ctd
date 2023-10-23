package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/clase16";
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
            "DOMICILIO_ID INT NOT NULL)";


    public static void crearDB() throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(SQL_CREATE_TABLE_DOMICILIO);
        statement.execute(SQL_CREATE_TABLE_PACIENTE);
    }

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER, PASS);
    }

}
