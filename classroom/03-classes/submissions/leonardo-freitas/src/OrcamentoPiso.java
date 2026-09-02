public class OrcamentoPiso {
    private final double comprimento;
    private final double largura;
    private final double precoPorMetroQuadrado;

    public OrcamentoPiso(double comprimento, double largura, double precoPorMetroQuadrado) {
        this.comprimento = comprimento > 0 ? comprimento : 1.0;
        this.largura = largura > 0 ? largura : 1.0;
        this.precoPorMetroQuadrado = precoPorMetroQuadrado >= 0 ? precoPorMetroQuadrado : 0.0;
    }

    public double obterComprimento() { return comprimento; }
    public double obterLargura() { return largura; }
    public double obterPrecoPorMetroQuadrado() { return precoPorMetroQuadrado; }
    public double calcularArea() { return comprimento * largura; }
    public double calcularComprimentoRodape() { return 2 * (comprimento + largura); }
    public double calcularPrecoTotal() { return calcularArea() * precoPorMetroQuadrado; }
}
