package com.tpi.tpf.service;

import com.tpi.tpf.dao.IDao;
import com.tpi.tpf.dao.TurnoDaoList;
import com.tpi.tpf.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;

    @Autowired
    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    //guardar
    public Turno save(Turno turno){
        return turnoIDao.save(turno);
    };

    //buascar
    public Turno getById(Integer id){
        return turnoIDao.getById(id);
    };

    //buscarTodos
    public List<Turno> getAll(){
        return turnoIDao.getAll();
    };

    //update
    public Turno updateAppointment(Turno turno){
        return turnoIDao.update(turno);
    }

    //Delete
    public void deleteById(Integer id){
        turnoIDao.delete(id);
    }
}
