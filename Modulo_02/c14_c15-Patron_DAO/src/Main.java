import dao.MedicamentoDaoH2;
import model.Medicamento;
import service.MedicamentoService;

public class Main {
    public static void main(String[] args) {

        Medicamento medicamento = new Medicamento("Ibuprofeno", "Lab123", 50, 520.0);

        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        medicamentoService.save(medicamento);
        Medicamento medicamento1 = medicamentoService.getById(2);

        System.out.println(medicamento1.getNombre());
    }
}