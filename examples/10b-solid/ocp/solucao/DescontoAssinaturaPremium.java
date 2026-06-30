package ocp.solucao;

public class DescontoAssinaturaPremium implements RegraDesconto {
    @Override
    public double aplicar(double valorBase) {
        return valorBase * 0.85;
    }
}
