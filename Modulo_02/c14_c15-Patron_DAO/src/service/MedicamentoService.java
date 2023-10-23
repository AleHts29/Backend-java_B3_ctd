package service;

import dao.IDao;
import model.Medicamento;

public class MedicamentoService {
    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    //Mketodos
    public Medicamento save(Medicamento medicamento){
        return medicamentoDao.save(medicamento);
    }

    public Medicamento getById(Integer id){
        return medicamentoDao.search(id);
    }
}
