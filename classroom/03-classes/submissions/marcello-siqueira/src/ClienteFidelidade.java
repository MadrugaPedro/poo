/**
 * Cliente de um programa de fidelidade.
 * Depois de desativado, o cadastro nao acumula nem resgata pontos.
 * A mesma classe atende os exercicios 7 e 9.
 */
public class ClienteFidelidade {

    private static final String NOME_PADRAO = "Cliente não identificado";

    private String nome;
    private int pontos;
    private boolean ativo;

    public ClienteFidelidade(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = NOME_PADRAO;
        } else {
            this.nome = nome;
        }

        this.pontos = 0;
        this.ativo = true;
    }

    /**
     * Acumula pontos apenas com cadastro ativo e quantidade positiva.
     */
    public void acumularPontos(int quantidade) {
        if (ativo && quantidade > 0) {
            pontos = pontos + quantidade;
        }
    }

    /**
     * Resgate exige cadastro ativo, quantidade positiva e saldo suficiente.
     * Recusa nao altera a pontuacao.
     */
    public boolean resgatarPontos(int quantidade) {
        if (!ativo) {
            return false;
        }

        if (quantidade <= 0) {
            return false;
        }

        if (quantidade > pontos) {
            return false;
        }

        pontos = pontos - quantidade;
        return true;
    }

    public void desativar() {
        this.ativo = false;
    }

    public String obterNome() {
        return nome;
    }

    public int obterPontos() {
        return pontos;
    }

    public boolean estaAtivo() {
        return ativo;
    }
}
