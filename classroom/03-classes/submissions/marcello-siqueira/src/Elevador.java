/**
 * Controla ocupacao e movimentacao de um elevador.
 * As guardas dos metodos de negocio mantem, nas operacoes normais,
 * 0 <= quantidadePessoas <= capacidade e 0 <= andarAtual <= ultimoAndar.
 * A soma da entrada de pessoas nao e protegida contra estouro de int.
 */
public class Elevador {

    private static final int TERREO = 0;
    private static final int VALOR_MINIMO = 1;

    private int andarAtual;
    private int ultimoAndar;
    private int capacidade;
    private int quantidadePessoas;

    public Elevador(int ultimoAndar, int capacidade) {
        if (ultimoAndar <= 0) {
            this.ultimoAndar = VALOR_MINIMO;
        } else {
            this.ultimoAndar = ultimoAndar;
        }

        if (capacidade <= 0) {
            this.capacidade = VALOR_MINIMO;
        } else {
            this.capacidade = capacidade;
        }

        this.andarAtual = TERREO;
        this.quantidadePessoas = 0;
    }

    /**
     * Entrada de pessoas. Recusa quantidade nao positiva ou que estoure a capacidade.
     */
    public boolean entrar(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }

        if (quantidadePessoas + quantidade > capacidade) {
            return false;
        }

        quantidadePessoas = quantidadePessoas + quantidade;
        return true;
    }

    /**
     * Saida de pessoas. Recusa quantidade nao positiva ou maior que a ocupacao.
     */
    public boolean sair(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }

        if (quantidade > quantidadePessoas) {
            return false;
        }

        quantidadePessoas = quantidadePessoas - quantidade;
        return true;
    }

    public boolean subir() {
        if (andarAtual >= ultimoAndar) {
            return false;
        }

        andarAtual = andarAtual + 1;
        return true;
    }

    public boolean descer() {
        if (andarAtual <= TERREO) {
            return false;
        }

        andarAtual = andarAtual - 1;
        return true;
    }

    public int obterAndarAtual() {
        return andarAtual;
    }

    public int obterUltimoAndar() {
        return ultimoAndar;
    }

    public int obterCapacidade() {
        return capacidade;
    }

    public int obterQuantidadePessoas() {
        return quantidadePessoas;
    }
}
