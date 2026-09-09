public class OrcamentoPisoApp {
    public static void main(String[] args){
            OrcamentoPiso orcamentoValido = new OrcamentoPiso(5.0, 3.0, 80.0);
            exibir(orcamentoValido);

            OrcamentoPiso orcamentoInvalido = new OrcamentoPiso(-5.0, -3.0, -80.0);
            exibir(orcamentoInvalido);
    }

    private static void exibir(OrcamentoPiso orcamento) {
                System.out.println("Dimensões: " + orcamento.obterComprimento() + "m x " + orcamento.obterLargura() +"m");
                System.out.println("Preço por m²: R$ " + orcamento.obterPrecoPorMetroQuadrado());
                System.out.println("Área calculada: " + orcamento.calcularArea());
                System.out.println("Comprimento do rodapé: " + orcamento.calcularComprimentoRodape());
                System.out.println("Preço total: " + orcamento.calcularPrecoTotal());
                }
}
