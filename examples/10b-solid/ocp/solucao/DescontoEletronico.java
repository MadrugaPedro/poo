package ocp.solucao;

public class DescontoEletronico implements RegraDesconto {
    @Override
    public double aplicar(double valorBase) {
        return valorBase * 0.90;
    }
}
