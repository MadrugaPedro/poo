/**
 * Demonstra entrada, retirada valida e retirada maior que o estoque.
 */
public class ProdutoApp {

    public static void main(String[] argumentos) {
        Produto caneta = new Produto("Caneta esferográfica azul", 3.50, 20);
        System.out.printf("%s | R$ %.2f | %d unidades | valor em estoque R$ %.2f%n",
                caneta.obterNome(), caneta.obterPrecoUnitario(),
                caneta.obterQuantidade(), caneta.calcularValorEstoque());

        System.out.println();
        System.out.println("Entrada de 30 unidades");
        caneta.adicionarEstoque(30);
        System.out.printf("%s | R$ %.2f | %d unidades | valor em estoque R$ %.2f%n",
                caneta.obterNome(), caneta.obterPrecoUnitario(),
                caneta.obterQuantidade(), caneta.calcularValorEstoque());

        System.out.println();
        String retiradaDeQuinze;
        if (caneta.retirarEstoque(15)) {
            retiradaDeQuinze = "aceita";
        } else {
            retiradaDeQuinze = "recusada";
        }
        System.out.println("Retirada de 15 unidades: " + retiradaDeQuinze);
        System.out.printf("%s | R$ %.2f | %d unidades | valor em estoque R$ %.2f%n",
                caneta.obterNome(), caneta.obterPrecoUnitario(),
                caneta.obterQuantidade(), caneta.calcularValorEstoque());

        System.out.println();
        String retiradaDeCem;
        if (caneta.retirarEstoque(100)) {
            retiradaDeCem = "aceita";
        } else {
            retiradaDeCem = "recusada";
        }
        System.out.println("Retirada de 100 unidades: " + retiradaDeCem);
        System.out.printf("%s | R$ %.2f | %d unidades | valor em estoque R$ %.2f%n",
                caneta.obterNome(), caneta.obterPrecoUnitario(),
                caneta.obterQuantidade(), caneta.calcularValorEstoque());

        System.out.println();
        System.out.println("Caso de fronteira: entrada de -5 e retirada de 0");
        caneta.adicionarEstoque(-5);
        String retiradaDeZero;
        if (caneta.retirarEstoque(0)) {
            retiradaDeZero = "aceita";
        } else {
            retiradaDeZero = "recusada";
        }
        System.out.println("Retirada de 0 unidades: " + retiradaDeZero);
        System.out.printf("%s | R$ %.2f | %d unidades | valor em estoque R$ %.2f%n",
                caneta.obterNome(), caneta.obterPrecoUnitario(),
                caneta.obterQuantidade(), caneta.calcularValorEstoque());

        System.out.println();
        System.out.println("Caso de fronteira: produto criado com dados inválidos");
        Produto invalido = new Produto("  ", -10.0, -7);
        System.out.printf("%s | R$ %.2f | %d unidades | valor em estoque R$ %.2f%n",
                invalido.obterNome(), invalido.obterPrecoUnitario(),
                invalido.obterQuantidade(), invalido.calcularValorEstoque());
    }
}
