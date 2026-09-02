public class Produto {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public Produto(String nome, double precoUnitario, int quantidade) {
        this.nome = (nome == null || nome.isBlank()) ? "Produto sem nome" : nome;
        this.precoUnitario = precoUnitario >= 0 ? precoUnitario : 0.0;
        this.quantidade = Math.max(quantidade, 0);
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade > 0) {
            this.quantidade += quantidade;
        }
    }

    public boolean retirarEstoque(int quantidade) {
        if (quantidade <= 0 || quantidade > this.quantidade) {
            return false;
        }
        this.quantidade -= quantidade;
        return true;
    }

    public String obterNome() { return nome; }
    public double obterPrecoUnitario() { return precoUnitario; }
    public int obterQuantidade() { return quantidade; }
    public double calcularValorEstoque() { return precoUnitario * quantidade; }
}
