public class IngressoCinema {
    private String tituloFilme;
    private double precoInteira;
    private boolean vendido;

    public IngressoCinema(String tituloFilme, double precoInteira) {
        this.tituloFilme = (tituloFilme == null || tituloFilme.isBlank()) ? "Filme não informado" : tituloFilme;
        this.precoInteira = precoInteira > 0 ? precoInteira : 1.0;
        this.vendido = false;
    }

    public double vender(boolean meiaEntrada) {
        if (vendido) {
            return 0.0;
        }
        vendido = true;
        return meiaEntrada ? precoInteira / 2.0 : precoInteira;
    }

    public String obterTituloFilme() { return tituloFilme; }
    public double obterPrecoInteira() { return precoInteira; }
    public boolean estaVendido() { return vendido; }
}
