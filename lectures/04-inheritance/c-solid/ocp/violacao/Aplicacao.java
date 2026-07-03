package ocp.violacao;

import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();
        carrinho.add(new Produto("Notebook", "eletronico", 3500.0));
        carrinho.add(new Produto("Camisa", "vestuario", 120.0));
        carrinho.add(new Produto("Curso Online", "servico", 250.0));
        carrinho.add(new Produto("Plano Premium", "assinatura-premium", 600.0));

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        for (Produto produto : carrinho) {
            double valorComDesconto = calculadora.aplicar(produto.getCategoria(), produto.getValorBase());
            System.out.println(produto.getNome() + ": R$ " + valorComDesconto);
        }
    }
}
