package ocp.violacao;

public class CalculadoraDesconto {
    public double aplicar(String categoria, double valorBase) {
        switch (categoria) {
            case "eletronico":
                return valorBase * 0.90;
            case "vestuario":
                return valorBase * 0.80;
            case "servico":
                return valorBase - 30.0;
            default:
                throw new IllegalArgumentException("Categoria não suportada: " + categoria);
        }
    }
}
