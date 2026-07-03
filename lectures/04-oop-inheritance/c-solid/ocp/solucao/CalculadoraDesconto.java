package ocp.solucao;

import java.util.HashMap;
import java.util.Map;

public class CalculadoraDesconto {
    private final Map<String, RegraDesconto> regras = new HashMap<>();

    public void registrar(String categoria, RegraDesconto regra) {
        regras.put(categoria, regra);
    }

    public double calcular(String categoria, double valorBase) {
        RegraDesconto regra = regras.get(categoria);
        if (regra == null) {
            throw new IllegalArgumentException("Categoria não suportada: " + categoria);
        }
        return regra.aplicar(valorBase);
    }
}
