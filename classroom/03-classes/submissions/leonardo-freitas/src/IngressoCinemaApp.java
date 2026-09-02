public class IngressoCinemaApp {
    public static void main(String[] argumentos) {
        IngressoCinema ingresso = new IngressoCinema("O Auto da Compadecida 2", 40.0);

        double primeiraVenda = ingresso.vender(true);
        System.out.printf("Primeira venda (meia-entrada): R$ %.2f%n", primeiraVenda);
        System.out.println("Vendido: " + ingresso.estaVendido());

        double segundaVenda = ingresso.vender(false);
        System.out.printf("Nova tentativa de venda: R$ %.2f (%s)%n",
                segundaVenda, segundaVenda == 0.0 ? "recusada" : "realizada");
    }
}
