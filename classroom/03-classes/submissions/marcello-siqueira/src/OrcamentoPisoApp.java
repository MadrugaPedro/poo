/**
 * Compara um orcamento valido com outro que teve dimensao normalizada.
 */
public class OrcamentoPisoApp {

    public static void main(String[] argumentos) {
        OrcamentoPiso sala = new OrcamentoPiso(5.0, 3.0, 80.00);
        OrcamentoPiso comDimensaoInvalida = new OrcamentoPiso(-4.0, 3.0, 80.00);

        System.out.println("Orçamento válido");
        exibir(sala);

        System.out.println();
        System.out.println("Caso de fronteira: comprimento negativo normalizado para 1.0 m");
        exibir(comDimensaoInvalida);
    }

    private static void exibir(OrcamentoPiso orcamento) {
        System.out.printf("Dimensões: %.2f m x %.2f m%n",
                orcamento.obterComprimento(), orcamento.obterLargura());
        System.out.printf("Preço por metro quadrado: R$ %.2f%n",
                orcamento.obterPrecoPorMetroQuadrado());
        System.out.printf("Área: %.2f m²%n", orcamento.calcularArea());
        System.out.printf("Rodapé: %.2f m%n", orcamento.calcularComprimentoRodape());
        System.out.printf("Preço total: R$ %.2f%n", orcamento.calcularPrecoTotal());
    }
}
