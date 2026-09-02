public class ProdutoApp {
    public static void main(String[] argumentos) {
        Produto produto = new Produto("Caderno", 24.90, 10);

        produto.adicionarEstoque(5);
        System.out.println("Após entrada: " + produto.obterQuantidade());

        System.out.println("Retirada de 4 unidades: " + (produto.retirarEstoque(4) ? "realizada" : "recusada"));
        System.out.println("Estoque atual: " + produto.obterQuantidade());

        System.out.println("Retirada maior que o estoque: " + (produto.retirarEstoque(100) ? "realizada" : "recusada"));
        System.out.printf("Valor do estoque: R$ %.2f%n", produto.calcularValorEstoque());
    }
}
