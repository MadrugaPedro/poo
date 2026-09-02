/**
 * Vende um ingresso de meia entrada e tenta vende lo de novo.
 */
public class IngressoCinemaApp {

    public static void main(String[] argumentos) {
        IngressoCinema ingresso = new IngressoCinema("Cidade de Deus", 40.00);

        System.out.println("Filme: " + ingresso.obterTituloFilme());
        System.out.printf("Preço da inteira: R$ %.2f%n", ingresso.obterPrecoInteira());
        System.out.println("Vendido: " + ingresso.estaVendido());

        System.out.println();
        double primeiraVenda = ingresso.vender(true);
        System.out.printf("Primeira venda, meia entrada: R$ %.2f cobrados%n", primeiraVenda);
        System.out.println("Vendido: " + ingresso.estaVendido());

        System.out.println();
        boolean jaEstavaVendido = ingresso.estaVendido();
        double segundaVenda = ingresso.vender(false);

        if (jaEstavaVendido) {
            System.out.println("Segunda venda recusada, o ingresso já foi vendido.");
        } else {
            System.out.printf("Segunda venda: R$ %.2f%n", segundaVenda);
        }
        System.out.println("Vendido: " + ingresso.estaVendido());

        System.out.println();
        System.out.println("Caso de fronteira: título vazio e preço zero");
        IngressoCinema invalido = new IngressoCinema("", 0.0);
        System.out.println("Filme: " + invalido.obterTituloFilme());
        System.out.printf("Preço da inteira: R$ %.2f%n", invalido.obterPrecoInteira());
        System.out.printf("Venda inteira: R$ %.2f%n", invalido.vender(false));
    }
}
