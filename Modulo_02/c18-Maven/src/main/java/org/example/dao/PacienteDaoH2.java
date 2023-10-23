package org.example.dao;



import org.example.db.DB;
import org.example.model.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente>{
    private static  final String SQL_INSERT="INSERT INTO PACIENTES(APELLIDO, NOMBRE, DNI, FECHA, DOMICILIO_ID) VALUES(?, ?, ?, ?, ?)";
    @Override
    public Paciente save(Paciente paciente) {
        Connection connection = null;
        try{
//Primero se debe guardar el domicilio del paciente que vienen cuando se carga la informacion del paciente
            DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
            domicilioDaoH2.save(paciente.getDomicilio());

            connection = DB.getConnection();
            PreparedStatement ps =  connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getApellido());
            ps.setString(2, paciente.getNombre());
            ps.setInt(3, paciente.getDni());
            ps.setDate(4, Date.valueOf(paciente.getFecha()));
            ps.setInt(5, (paciente.getDomicilio()).getId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()){
                paciente.setId(rs.getInt(1));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Paciente getById(Integer id) {
        return null;
    }

    @Override
    public List<Paciente> getAll() {
        return null;
    }
}
