package dip.solucao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVendasMySql implements RepositorioVendas {
    @Override
    public List<Venda> buscarPorMes(int ano, int mes) {
        System.out.println("Consultando banco MySQL...");
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(LocalDate.of(ano, mes, 1), 1200.0));
        vendas.add(new Venda(LocalDate.of(ano, mes, 5), 850.0));
        return vendas;
    }
}
