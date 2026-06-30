package ocp.solucao;

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
        calculadora.registrar("eletronico", new DescontoEletronico());
        calculadora.registrar("vestuario", new DescontoVestuario());
        calculadora.registrar("servico", new DescontoServico());
        calculadora.registrar("assinatura-premium", new DescontoAssinaturaPremium());

        for (Produto produto : carrinho) {
            double valorComDesconto = calculadora.calcular(produto.getCategoria(), produto.getValorBase());
            System.out.println(produto.getNome() + ": R$ " + valorComDesconto);
        }
    }
}
