package ocp.solucao;

public class DescontoServico implements RegraDesconto {
    @Override
    public double aplicar(double valorBase) {
        return valorBase - 30.0;
    }
}
