package dao;

import model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;

public class MedicamentoDaoH2 implements IDao<Medicamento>{
    private static final String SQL_INSERT="INSERT INTO MEDICAMENTOS(NOMBRE, LABORATORIO, CANTIDAD, PRECIO) VALUES (?,?,?,?)";
    private static final String SQL_SELECT="SELECT * FROM MEDICAMENTOS WHERE ID=?";

    private static final Logger logger = Logger.getLogger(MedicamentoDaoH2.class);

    @Override
    public Medicamento save(Medicamento medicamento) {
        //implementamos el logger
        logger.info("Registrando nuevo medicamento: "+medicamento.getNombre());

        //conectatar con la db y guardar los datos
        Connection connection = null;
        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, medicamento.getNombre());
            ps.setString(2, medicamento.getLaboratorio());
            ps.setInt(3, medicamento.getCantidad());
            ps.setDouble(4, medicamento.getPrecio());
            ps.executeUpdate();

            //Procesar la clave generada
            ResultSet claveGenerada = ps.getGeneratedKeys();
            while (claveGenerada.next()){
                medicamento.setId(claveGenerada.getInt(1));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return medicamento;
    }

    @Override
    public Medicamento search(Integer id) {
        //implementamos el logger
        logger.info("Buscando nuevo medicamento con ID: "+id);

        Connection connection = null;
        Medicamento medicamento = null;
        try{
            connection = DB.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                medicamento = new Medicamento(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }
}
