/**
 * Carteira digital com saldo protegido.
 * A transferencia e um exemplo de colaboracao: um objeto Carteira recebe
 * outra Carteira como parametro e usa os metodos publicos dela.
 */
public class Carteira {

    private static final String TITULAR_PADRAO = "Sem nome";

    private String titular;
    private double saldo;

    public Carteira(String titular, double saldo) {
        if (titular == null || titular.trim().isEmpty()) {
            this.titular = TITULAR_PADRAO;
        } else {
            this.titular = titular;
        }

        if (saldo < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldo;
        }
    }

    public void adicionarDinheiro(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        }
    }

    /**
     * Gasto exige valor positivo e saldo suficiente. Recusa nao altera o saldo.
     */
    public boolean gastar(double valor) {
        if (valor <= 0) {
            return false;
        }

        if (valor > saldo) {
            return false;
        }

        saldo = saldo - valor;
        return true;
    }

    /**
     * Transferencia exige destino existente e diferente desta carteira.
     * A comparacao usa != com this: interessa saber se as duas referencias
     * alcancam o mesmo objeto, nao se os dados sao iguais.
     * O debito so acontece se gastar devolver true, entao uma recusa nao
     * modifica nenhuma das duas carteiras.
     */
    public boolean transferirPara(Carteira destino, double valor) {
        if (destino == null) {
            return false;
        }

        if (destino == this) {
            return false;
        }

        if (!gastar(valor)) {
            return false;
        }

        destino.adicionarDinheiro(valor);
        return true;
    }

    public String obterTitular() {
        return titular;
    }

    public double obterSaldo() {
        return saldo;
    }
}
