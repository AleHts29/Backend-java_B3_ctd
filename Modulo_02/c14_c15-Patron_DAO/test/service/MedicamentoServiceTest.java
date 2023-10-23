package service;

import dao.DB;
import dao.MedicamentoDaoH2;
import model.Medicamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());

    @Test
    public void saveMedicamentoTest() throws Exception {
        DB.crearDB();

        //Given
        Medicamento medicamento = new Medicamento("Ibuprofeno", "Lab123", 50, 520.0);

        //Then
        medicamentoService.save(medicamento);

        //Assert
        assertTrue(medicamento.getId()==1);
    }
}