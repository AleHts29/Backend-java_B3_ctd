import org.apache.log4j.Logger;

import java.sql.*;


public class Main {
//Declaracion de sentencias SQL
    private static final String SQL_CREATE_TABLE="DROP TABLE IF EXISTS USERS;" +
            "CREATE TABLE USERS(" +
            "ID INT PRIMARY KEY," +
            "FIRST_NAME VARCHAR(100) NOT NULL," +
            "LAST_NAME VARCHAR(100) NOT NULL," +
            "AGE INT NOT NULL )";

    private static final String SQL_INSERT = "INSERT INTO USERS(ID, FIRST_NAME, LAST_NAME, AGE) " +
            "VALUES" +
            "(1, 'JUAN', 'NAVARRO', 32)," +
            "(2, 'CARLOS', 'ROJAS', 37)," +
            "(3, 'PEDRO', 'CAFIERO', 25)," +
            "(4, 'IVAN', 'ORTIZ', 22)";

    private static final String SQL_SELECT  = "SELECT * FROM USERS";

    private static final String SQL_DELETE  = "DELETE FROM USERS WHERE ID=3";

    private static final Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args){
        Connection connection=null;
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(SQL_CREATE_TABLE);
            statement.execute(SQL_INSERT);

            // Usamos el logger
            statement.execute(SQL_DELETE);
            logger.warn("Se elimino al usuario con id=3");

            // Mostrar datos de la DB
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while (rs.next()){
                System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3)+"-"+rs.getInt(4));
            }
            System.out.println("Hello world!");
        }catch (Exception exception){
            logger.error(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(
                "jdbc:h2:~/clase12",
                "sa",
                "sa");
    }
}