/**
 * Controla o estoque de um produto.
 * As guardas dos metodos de negocio mantem a quantidade nao negativa nas
 * operacoes normais: a entrada so aceita quantidade positiva e a retirada
 * so acontece quando ha estoque suficiente. A soma da entrada nao e
 * protegida contra estouro de int.
 * A quantidade so muda pelos metodos de negocio, nunca por atribuicao externa,
 * porque o atributo e privado e nao existe metodo de alteracao direta.
 */
public class Produto {

    private static final String NOME_PADRAO = "Produto sem nome";

    private String nome;
    private double precoUnitario;
    private int quantidade;

    public Produto(String nome, double precoUnitario, int quantidade) {
        if (nome == null || nome.trim().isEmpty()) {
            this.nome = NOME_PADRAO;
        } else {
            this.nome = nome;
        }

        if (precoUnitario < 0) {
            this.precoUnitario = 0.0;
        } else {
            this.precoUnitario = precoUnitario;
        }

        if (quantidade < 0) {
            this.quantidade = 0;
        } else {
            this.quantidade = quantidade;
        }
    }

    /**
     * Entrada de estoque. Quantidade nao positiva e ignorada.
     */
    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade = this.quantidade + quantidade;
        }
    }

    /**
     * Retirada de estoque. Devolve false e nao altera o estado quando a
     * quantidade nao e positiva ou quando o estoque e insuficiente.
     */
    public boolean retirarEstoque(int quantidade) {
        if (quantidade <= 0) {
            return false;
        }

        if (quantidade > this.quantidade) {
            return false;
        }

        this.quantidade = this.quantidade - quantidade;
        return true;
    }

    public String obterNome() {
        return nome;
    }

    public double obterPrecoUnitario() {
        return precoUnitario;
    }

    public int obterQuantidade() {
        return quantidade;
    }

    public double calcularValorEstoque() {
        return precoUnitario * quantidade;
    }
}
