package com.tpi.tpf.dao;

import com.tpi.tpf.model.Turno;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDaoList implements IDao<Turno>{
    private List<Turno> turnos;

    public TurnoDaoList(){
        turnos = new ArrayList<>();
    }

    @Override
    public Turno save(Turno turno) {
        turnos.add(turno);
        return turno;
    }

    @Override
    public Turno getById(Integer id) {
        Turno turnoFind = null;
        for (Turno turno: turnos) {
            if(turno.getId()==id){
                turnoFind = turno;
                return turnoFind;
            }
        }
        return turnoFind;
    }

    @Override
    public Turno getByCriterio(String criterio) {
        return null;
    }

    @Override
    public List<Turno> getAll() {
        return turnos;
    }

    @Override
    public Turno update(Turno turno) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }


}
