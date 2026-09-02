public class MaquinaVendas {
    private String nomeProduto;
    private double precoUnitario;
    private int estoque;
    private double credito;

    public MaquinaVendas(String nomeProduto, double precoUnitario, int estoque) {
        this.nomeProduto = (nomeProduto == null || nomeProduto.isBlank()) ? "Produto não informado" : nomeProduto;
        this.precoUnitario = precoUnitario > 0 ? precoUnitario : 1.0;
        this.estoque = Math.max(estoque, 0);
        this.credito = 0.0;
    }

    public void inserirDinheiro(double valor) {
        if (valor > 0) {
            credito += valor;
        }
    }

    public boolean comprar() {
        if (estoque <= 0 || credito < precoUnitario) {
            return false;
        }
        estoque--;
        credito -= precoUnitario;
        return true;
    }

    public double cancelar() {
        double devolucao = credito;
        credito = 0.0;
        return devolucao;
    }

    public String obterNomeProduto() { return nomeProduto; }
    public double obterPrecoUnitario() { return precoUnitario; }
    public int obterEstoque() { return estoque; }
    public double obterCredito() { return credito; }
}
