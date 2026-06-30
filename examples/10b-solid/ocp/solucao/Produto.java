package ocp.solucao;

public class Produto {
    private final String nome;
    private final String categoria;
    private final double valorBase;

    public Produto(String nome, String categoria, double valorBase) {
        this.nome = nome;
        this.categoria = categoria;
        this.valorBase = valorBase;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValorBase() {
        return valorBase;
    }
}
