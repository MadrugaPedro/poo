package srp.solucao;

import java.time.LocalDate;
import java.util.List;

public class ProcessadorFolha {
    private final CalculadoraFolha calculadora;
    private final GeradorRelatorioFolha gerador;
    private final MensageiroFolha mensageiro;

    public ProcessadorFolha(CalculadoraFolha calculadora, GeradorRelatorioFolha gerador, MensageiroFolha mensageiro) {
        this.calculadora = calculadora;
        this.gerador = gerador;
        this.mensageiro = mensageiro;
    }

    public void processar(List<Funcionario> funcionarios) {
        double total = calculadora.calcularTotal(funcionarios);
        String relatorio = gerador.gerar(LocalDate.now(), funcionarios, total);
        mensageiro.enviarParaDiretoria(relatorio);
    }
}
