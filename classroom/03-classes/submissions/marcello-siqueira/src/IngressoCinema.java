/**
 * Representa um ingresso de cinema que so pode ser vendido uma vez.
 * A regra de venda unica fica dentro do objeto, nao no programa que o usa.
 */
public class IngressoCinema {

    private static final String TITULO_PADRAO = "Filme não informado";
    private static final double PRECO_PADRAO = 1.0;

    private String tituloFilme;
    private double precoInteira;
    private boolean vendido;

    public IngressoCinema(String tituloFilme, double precoInteira) {
        if (tituloFilme == null || tituloFilme.trim().isEmpty()) {
            this.tituloFilme = TITULO_PADRAO;
        } else {
            this.tituloFilme = tituloFilme;
        }

        if (precoInteira <= 0) {
            this.precoInteira = PRECO_PADRAO;
        } else {
            this.precoInteira = precoInteira;
        }

        this.vendido = false;
    }

    /**
     * Vende o ingresso e devolve o valor cobrado.
     * Se o ingresso ja estiver vendido, devolve 0.0 e nao altera o estado,
     * que e a forma de sinalizar recusa em um metodo que retorna double.
     */
    public double vender(boolean meiaEntrada) {
        if (vendido) {
            return 0.0;
        }

        this.vendido = true;

        if (meiaEntrada) {
            return precoInteira / 2;
        }

        return precoInteira;
    }

    public String obterTituloFilme() {
        return tituloFilme;
    }

    public double obterPrecoInteira() {
        return precoInteira;
    }

    public boolean estaVendido() {
        return vendido;
    }
}
