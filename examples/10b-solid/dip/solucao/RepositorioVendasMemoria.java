package dip.solucao;

import java.util.ArrayList;
import java.util.List;

public class RepositorioVendasMemoria implements RepositorioVendas {
    private final List<Venda> vendas;

    public RepositorioVendasMemoria(List<Venda> vendas) {
        this.vendas = new ArrayList<>(vendas);
    }

    @Override
    public List<Venda> buscarPorMes(int ano, int mes) {
        List<Venda> resultado = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getData().getYear() == ano && venda.getData().getMonthValue() == mes) {
                resultado.add(venda);
            }
        }
        return resultado;
    }
}
