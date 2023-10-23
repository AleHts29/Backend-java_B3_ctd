import java.sql.*;

public class Main {
//Declaracion de sentencia SQL
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES(" +
        "ID INT PRIMARY KEY," +
        "NOMBRE VARCHAR(100) NOT NULL," +
        "TIPO VARCHAR(100) NOT NULL)";

    private static final String SQL_INSERT = "INSERT INTO ANIMALES(ID, NOMBRE, TIPO) VALUES" +
            "(1, 'PANCHO', 'PERRO')," +
            "(2, 'ORIANA', 'GATO')," +
            "(3, 'HOMERO', 'PERRO')";

    private static final String SQL_SELECT = "SELECT * FROM ANIMALES";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:~/clase11","sa", "sa");

        Statement statement = connection.createStatement();
        statement.execute(SQL_CREATE_TABLE);
        statement.execute(SQL_INSERT);

        // Para recorrer lo que me retorna una consulta de SQL desde Java usamos ResultSet
        ResultSet rs = statement.executeQuery(SQL_SELECT);
        while (rs.next()){
            System.out.println(rs.getInt(1)+"-"+rs.getString(2)+"-"+rs.getString(3));
        }

        System.out.println("Hello world!");
    }
}