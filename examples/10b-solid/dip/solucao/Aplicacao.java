package dip.solucao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        RepositorioVendas repositorioMySql = new RepositorioVendasMySql();
        ServicoRelatorioVendas servicoMySql = new ServicoRelatorioVendas(repositorioMySql);
        System.out.println(servicoMySql.gerarResumoMensal(2024, 3));

        List<Venda> vendasTeste = new ArrayList<>();
        vendasTeste.add(new Venda(LocalDate.of(2024, 3, 1), 1200.0));
        vendasTeste.add(new Venda(LocalDate.of(2024, 4, 10), 900.0));

        RepositorioVendas repositorioMemoria = new RepositorioVendasMemoria(vendasTeste);
        ServicoRelatorioVendas servicoMemoria = new ServicoRelatorioVendas(repositorioMemoria);
        System.out.println(servicoMemoria.gerarResumoMensal(2024, 3));
    }
}
