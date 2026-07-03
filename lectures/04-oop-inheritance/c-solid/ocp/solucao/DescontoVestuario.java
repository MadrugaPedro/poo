package ocp.solucao;

public class DescontoVestuario implements RegraDesconto {
    @Override
    public double aplicar(double valorBase) {
        return valorBase * 0.80;
    }
}
