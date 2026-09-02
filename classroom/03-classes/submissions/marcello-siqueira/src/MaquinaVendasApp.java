import java.util.Scanner;

/**
 * Demonstra compras recusadas e depois oferece um menu interativo.
 */
public class MaquinaVendasApp {

    public static void main(String[] argumentos) {
        demonstrarComprasRecusadas();

        MaquinaVendas maquina = new MaquinaVendas("Refrigerante lata", 5.50, 3);
        exibirMenu(maquina);
    }

    /**
     * Casos que a maquina precisa recusar sem alterar o proprio estado.
     */
    private static void demonstrarComprasRecusadas() {
        System.out.println("Demonstração das compras recusadas");

        MaquinaVendas semCredito = new MaquinaVendas("Chocolate", 7.00, 2);
        System.out.printf("Estoque %d, crédito R$ %.2f%n",
                semCredito.obterEstoque(), semCredito.obterCredito());
        String compraSemCredito;
        if (semCredito.comprar()) {
            compraSemCredito = "aceita";
        } else {
            compraSemCredito = "recusada";
        }
        System.out.println("Comprar sem crédito: " + compraSemCredito);

        semCredito.inserirDinheiro(3.00);
        double creditoDisponivel = semCredito.obterCredito();
        String compraComCreditoInsuficiente;
        if (semCredito.comprar()) {
            compraComCreditoInsuficiente = "aceita";
        } else {
            compraComCreditoInsuficiente = "recusada";
        }
        System.out.printf("Comprar com crédito de R$ %.2f, preço R$ %.2f: %s%n",
                creditoDisponivel, semCredito.obterPrecoUnitario(), compraComCreditoInsuficiente);
        System.out.printf("Estoque continua %d, crédito continua R$ %.2f%n",
                semCredito.obterEstoque(), semCredito.obterCredito());

        System.out.println();
        MaquinaVendas semEstoque = new MaquinaVendas("Água mineral", 4.00, 0);
        semEstoque.inserirDinheiro(20.00);
        System.out.printf("Estoque %d, crédito R$ %.2f%n",
                semEstoque.obterEstoque(), semEstoque.obterCredito());
        String compraSemEstoque;
        if (semEstoque.comprar()) {
            compraSemEstoque = "aceita";
        } else {
            compraSemEstoque = "recusada";
        }
        System.out.println("Comprar sem estoque: " + compraSemEstoque);
        System.out.printf("Crédito continua R$ %.2f%n", semEstoque.obterCredito());
        System.out.printf("Cancelamento devolve R$ %.2f%n", semEstoque.cancelar());
        System.out.printf("Crédito após o cancelamento: R$ %.2f%n", semEstoque.obterCredito());

        System.out.println();
        System.out.println("Caso de fronteira: produto vazio, preço zero e estoque negativo");
        MaquinaVendas normalizada = new MaquinaVendas("", 0.0, -5);
        System.out.printf("%s | R$ %.2f | %d unidades%n", normalizada.obterNomeProduto(),
                normalizada.obterPrecoUnitario(), normalizada.obterEstoque());

        System.out.println();
    }

    /**
     * Menu com as quatro operacoes pedidas. Ao encerrar, devolve o credito restante.
     */
    private static void exibirMenu(MaquinaVendas maquina) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 4) {
            System.out.println();
            System.out.printf("Máquina de %s | R$ %.2f | %d em estoque | crédito R$ %.2f%n",
                    maquina.obterNomeProduto(), maquina.obterPrecoUnitario(),
                    maquina.obterEstoque(), maquina.obterCredito());
            System.out.println("1. Inserir dinheiro");
            System.out.println("2. Comprar");
            System.out.println("3. Cancelar");
            System.out.println("4. Encerrar");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida.");
                scanner.next();
                continue;
            }

            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.print("Valor a inserir: ");

                if (!scanner.hasNextDouble()) {
                    System.out.println("Valor inválido.");
                    scanner.next();
                    continue;
                }

                double valor = scanner.nextDouble();
                maquina.inserirDinheiro(valor);
                System.out.printf("Crédito atual: R$ %.2f%n", maquina.obterCredito());
            } else if (opcao == 2) {
                if (maquina.comprar()) {
                    System.out.println("Produto liberado.");
                } else {
                    System.out.println("Compra recusada por falta de crédito ou de estoque.");
                }
            } else if (opcao == 3) {
                System.out.printf("Devolvido R$ %.2f%n", maquina.cancelar());
            } else if (opcao == 4) {
                System.out.printf("Crédito restante devolvido: R$ %.2f%n", maquina.cancelar());
                System.out.println("Máquina encerrada.");
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
