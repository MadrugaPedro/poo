public class OrcamentoPisoApp {
    public static void main(String[] argumentos) {
        OrcamentoPiso sala = new OrcamentoPiso(5.0, 3.0, 80.0);
        OrcamentoPiso ambienteComDimensaoInvalida = new OrcamentoPiso(-2.0, 4.0, 65.0);

        exibir(sala);
        exibir(ambienteComDimensaoInvalida);
    }

    private static void exibir(OrcamentoPiso orcamento) {
        System.out.printf(
                "Dimensões: %.1f m x %.1f m | Área: %.2f m² | Rodapé: %.2f m | Preço/m²: R$ %.2f | Total: R$ %.2f%n",
                orcamento.obterComprimento(), orcamento.obterLargura(), orcamento.calcularArea(),
                orcamento.calcularComprimentoRodape(), orcamento.obterPrecoPorMetroQuadrado(),
                orcamento.calcularPrecoTotal());
    }
}
