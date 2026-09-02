public class Carteira {
    private String titular;
    private double saldo;

    public Carteira(String titular, double saldo) {
        this.titular = (titular == null || titular.isBlank()) ? "Sem nome" : titular;
        this.saldo = Math.max(saldo, 0.0);
    }

    public void adicionarDinheiro(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public boolean gastar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean transferirPara(Carteira destino, double valor) {
        if (destino == null || destino == this || valor <= 0 || valor > saldo) {
            return false;
        }
        saldo -= valor;
        destino.saldo += valor;
        return true;
    }

    public String obterTitular() { return titular; }
    public double obterSaldo() { return saldo; }
}
