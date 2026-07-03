package srp.solucao;

import java.util.List;

public class CalculadoraFolha {
    public double calcularTotal(List<Funcionario> funcionarios) {
        double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.getSalarioBase();
        }
        return total;
    }
}
