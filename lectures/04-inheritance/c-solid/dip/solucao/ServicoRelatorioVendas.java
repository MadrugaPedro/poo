package dip.solucao;

import java.util.List;

public class ServicoRelatorioVendas {
    private final RepositorioVendas repositorio;

    public ServicoRelatorioVendas(RepositorioVendas repositorio) {
        this.repositorio = repositorio;
    }

    public String gerarResumoMensal(int ano, int mes) {
        List<Venda> vendas = repositorio.buscarPorMes(ano, mes);
        double total = 0.0;
        for (Venda venda : vendas) {
            total += venda.getValor();
        }
        return "Vendas de " + mes + "/" + ano + ": R$ " + total;
    }
}
