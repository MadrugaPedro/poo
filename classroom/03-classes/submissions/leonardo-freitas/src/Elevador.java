public class Elevador {
    private int andarAtual;
    private int ultimoAndar;
    private int capacidade;
    private int quantidadePessoas;

    public Elevador(int ultimoAndar, int capacidade) {
        this.ultimoAndar = ultimoAndar > 0 ? ultimoAndar : 1;
        this.capacidade = capacidade > 0 ? capacidade : 1;
        this.andarAtual = 0;
        this.quantidadePessoas = 0;
    }

    public boolean entrar(int quantidade) {
        if (quantidade <= 0 || quantidadePessoas + quantidade > capacidade) {
            return false;
        }
        quantidadePessoas += quantidade;
        return true;
    }

    public boolean sair(int quantidade) {
        if (quantidade <= 0 || quantidade > quantidadePessoas) {
            return false;
        }
        quantidadePessoas -= quantidade;
        return true;
    }

    public boolean subir() {
        if (andarAtual >= ultimoAndar) {
            return false;
        }
        andarAtual++;
        return true;
    }

    public boolean descer() {
        if (andarAtual <= 0) {
            return false;
        }
        andarAtual--;
        return true;
    }

    public int obterAndarAtual() { return andarAtual; }
    public int obterUltimoAndar() { return ultimoAndar; }
    public int obterCapacidade() { return capacidade; }
    public int obterQuantidadePessoas() { return quantidadePessoas; }
}
