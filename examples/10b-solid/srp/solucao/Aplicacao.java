package srp.solucao;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        List<Funcionario> equipe = new ArrayList<>();
        equipe.add(new Funcionario("Ana", 6400.0));
        equipe.add(new Funcionario("Bruno", 5200.0));

        CalculadoraFolha calculadora = new CalculadoraFolha();
        GeradorRelatorioFolha gerador = new GeradorRelatorioFolha();
        MensageiroFolha mensageiro = new MensageiroFolha();

        ProcessadorFolha processador = new ProcessadorFolha(calculadora, gerador, mensageiro);
        processador.processar(equipe);
    }
}
