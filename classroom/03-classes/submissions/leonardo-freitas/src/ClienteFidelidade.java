public class ClienteFidelidade {
    private String nome;
    private int pontos;
    private boolean ativo;

    public ClienteFidelidade(String nome) {
        this.nome = (nome == null || nome.isBlank()) ? "Cliente não identificado" : nome;
        this.pontos = 0;
        this.ativo = true;
    }

    public void acumularPontos(int quantidade) {
        if (ativo && quantidade > 0) {
            pontos += quantidade;
        }
    }

    public boolean resgatarPontos(int quantidade) {
        if (!ativo || quantidade <= 0 || quantidade > pontos) {
            return false;
        }
        pontos -= quantidade;
        return true;
    }

    public void desativar() { ativo = false; }
    public String obterNome() { return nome; }
    public int obterPontos() { return pontos; }
    public boolean estaAtivo() { return ativo; }
}
