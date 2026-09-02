import java.util.Scanner;

public class MaquinaVendasApp {
    public static void main(String[] argumentos) {
        demonstrarComprasRecusadas();

        MaquinaVendas maquina = new MaquinaVendas("Água", 4.50, 3);
        exibirMenu(maquina);
    }

    private static void demonstrarComprasRecusadas() {
        MaquinaVendas semCredito = new MaquinaVendas("Suco", 6.0, 2);
        System.out.println("Compra sem crédito: " + (semCredito.comprar() ? "realizada" : "recusada"));

        MaquinaVendas semEstoque = new MaquinaVendas("Biscoito", 5.0, 0);
        semEstoque.inserirDinheiro(10.0);
        System.out.println("Compra sem estoque: " + (semEstoque.comprar() ? "realizada" : "recusada"));
        System.out.printf("Crédito preservado após recusa: R$ %.2f%n", semEstoque.obterCredito());
    }

    private static void exibirMenu(MaquinaVendas maquina) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.printf("%nProduto: %s | Preço: R$ %.2f | Estoque: %d | Crédito: R$ %.2f%n",
                    maquina.obterNomeProduto(), maquina.obterPrecoUnitario(), maquina.obterEstoque(), maquina.obterCredito());
            System.out.println("1 - Inserir dinheiro");
            System.out.println("2 - Comprar");
            System.out.println("3 - Cancelar");
            System.out.println("0 - Encerrar");
            System.out.print("Opção: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Opção inválida.");
                continue;
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Valor: R$ ");
                    if (scanner.hasNextDouble()) {
                        maquina.inserirDinheiro(scanner.nextDouble());
                    } else {
                        scanner.next();
                        System.out.println("Valor inválido.");
                    }
                }
                case 2 -> System.out.println(maquina.comprar() ? "Compra realizada." : "Compra recusada.");
                case 3 -> System.out.printf("Valor devolvido: R$ %.2f%n", maquina.cancelar());
                case 0 -> System.out.printf("Encerrando. Troco devolvido: R$ %.2f%n", maquina.cancelar());
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
