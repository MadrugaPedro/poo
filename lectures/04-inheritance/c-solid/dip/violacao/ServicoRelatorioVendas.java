package dip.violacao;

import java.util.List;

public class ServicoRelatorioVendas {
    public String gerarResumoMensal(int ano, int mes) {
        RepositorioVendasMySql repositorio = new RepositorioVendasMySql();
        List<Venda> vendas = repositorio.buscarPorMes(ano, mes);
        double total = 0.0;
        for (Venda venda : vendas) {
            total += venda.getValor();
        }
        return "Vendas de " + mes + "/" + ano + ": R$ " + total;
    }
}
