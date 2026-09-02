/**
 * Maquina de vendas de um unico produto.
 * Invariantes mantidas pela classe: estoque >= 0 e credito >= 0.
 */
public class MaquinaVendas {

    private static final String PRODUTO_PADRAO = "Produto não informado";
    private static final double PRECO_PADRAO = 1.0;

    private String nomeProduto;
    private double precoUnitario;
    private int estoque;
    private double credito;

    public MaquinaVendas(String nomeProduto, double precoUnitario, int estoque) {
        if (nomeProduto == null || nomeProduto.trim().isEmpty()) {
            this.nomeProduto = PRODUTO_PADRAO;
        } else {
            this.nomeProduto = nomeProduto;
        }

        if (precoUnitario <= 0) {
            this.precoUnitario = PRECO_PADRAO;
        } else {
            this.precoUnitario = precoUnitario;
        }

        if (estoque < 0) {
            this.estoque = 0;
        } else {
            this.estoque = estoque;
        }

        this.credito = 0.0;
    }

    public void inserirDinheiro(double valor) {
        if (valor > 0) {
            credito = credito + valor;
        }
    }

    /**
     * Compra exige estoque e credito suficientes.
     * Recusa nao altera estoque nem credito.
     */
    public boolean comprar() {
        if (estoque <= 0) {
            return false;
        }

        if (credito < precoUnitario) {
            return false;
        }

        estoque = estoque - 1;
        credito = credito - precoUnitario;
        return true;
    }

    /**
     * Devolve todo o credito acumulado e zera o valor guardado na maquina.
     */
    public double cancelar() {
        double devolucao = credito;
        credito = 0.0;
        return devolucao;
    }

    public String obterNomeProduto() {
        return nomeProduto;
    }

    public double obterPrecoUnitario() {
        return precoUnitario;
    }

    public int obterEstoque() {
        return estoque;
    }

    public double obterCredito() {
        return credito;
    }
}
