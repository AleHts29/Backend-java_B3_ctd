package com.tpi.tpf.service;

import com.tpi.tpf.dao.IDao;
import com.tpi.tpf.dao.TurnoDaoList;
import com.tpi.tpf.model.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {
    private IDao<Turno> turnoIDao;

    public TurnoService() {
        this.turnoIDao = new TurnoDaoList();
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
}
