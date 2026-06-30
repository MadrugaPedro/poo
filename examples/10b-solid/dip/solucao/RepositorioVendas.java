package dip.solucao;

import java.util.List;

public interface RepositorioVendas {
    List<Venda> buscarPorMes(int ano, int mes);
}
