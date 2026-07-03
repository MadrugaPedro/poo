package dip.violacao;

import java.time.LocalDate;

public class Venda {
    private final LocalDate data;
    private final double valor;

    public Venda(LocalDate data, double valor) {
        this.data = data;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}
