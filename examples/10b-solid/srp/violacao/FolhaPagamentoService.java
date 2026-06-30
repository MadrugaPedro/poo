package srp.violacao;

import java.time.LocalDate;
import java.util.List;

public class FolhaPagamentoService {
    private final List<Funcionario> funcionarios;

    public FolhaPagamentoService(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void processarFolhaMensal() {
        double total = calcularTotal();
        String relatorio = gerarRelatorio(total);
        enviarRelatorio(relatorio);
    }

    private double calcularTotal() {
        double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.getSalarioBase();
        }
        System.out.println("Total de salários calculado: R$ " + total);
        return total;
    }

    private String gerarRelatorio(double total) {
        StringBuilder builder = new StringBuilder();
        builder.append("Relatório de folha de pagamento - ")
                .append(LocalDate.now())
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

    private void enviarRelatorio(String relatorio) {
        System.out.println("Enviando relatório por e-mail para a diretoria...");
        System.out.println(relatorio);
    }
}
