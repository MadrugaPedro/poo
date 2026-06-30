package srp.solucao;

import java.time.LocalDate;
import java.util.List;

public class GeradorRelatorioFolha {
    public String gerar(LocalDate referencia, List<Funcionario> funcionarios, double total) {
        StringBuilder builder = new StringBuilder();
        builder.append("Relatório de folha de pagamento - ")
                .append(referencia)
                .append("\nFuncionários:\n");
        for (Funcionario funcionario : funcionarios) {
            builder.append(" - ")
                    .append(funcionario.getNome())
                    .append(": R$ ")
                    .append(funcionario.getSalarioBase())
                    .append('\n');
        }
        builder.append("Total: R$ ").append(total);
        return builder.toString();
    }
}
