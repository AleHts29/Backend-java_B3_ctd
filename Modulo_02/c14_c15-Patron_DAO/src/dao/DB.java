package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/clase14";
    private static final String USER = "sa";
    private static final String PASS = "sa";

    private static final String SQL_CRETATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS; CREATE TABLE MEDICAMENTOS(" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "LABORATORIO VARCHAR(100) NOT NULL," +
            "CANTIDAD INT," +
            "PRECIO NUMERIC(10,2) NOT NULL)";

    public static void crearDB() throws Exception{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute(SQL_CRETATE_TABLE);
    }

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL,USER,PASS);
    }
}
