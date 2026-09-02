/**
 * Calcula area, rodape e preco total de um ambiente retangular.
 * Os atributos sao final: depois de construido, o orcamento nao muda,
 * e a classe nao expoe nenhum metodo de alteracao.
 */
public class OrcamentoPiso {

    private static final double DIMENSAO_PADRAO = 1.0;

    private final double comprimento;
    private final double largura;
    private final double precoPorMetroQuadrado;

    public OrcamentoPiso(double comprimento, double largura, double precoPorMetroQuadrado) {
        if (comprimento <= 0) {
            this.comprimento = DIMENSAO_PADRAO;
        } else {
            this.comprimento = comprimento;
        }

        if (largura <= 0) {
            this.largura = DIMENSAO_PADRAO;
        } else {
            this.largura = largura;
        }

        if (precoPorMetroQuadrado < 0) {
            this.precoPorMetroQuadrado = 0.0;
        } else {
            this.precoPorMetroQuadrado = precoPorMetroQuadrado;
        }
    }

    public double obterComprimento() {
        return comprimento;
    }

    public double obterLargura() {
        return largura;
    }

    public double obterPrecoPorMetroQuadrado() {
        return precoPorMetroQuadrado;
    }

    public double calcularArea() {
        return comprimento * largura;
    }

    /**
     * O rodape acompanha o perimetro do comodo.
     */
    public double calcularComprimentoRodape() {
        return 2 * (comprimento + largura);
    }

    public double calcularPrecoTotal() {
        return calcularArea() * precoPorMetroQuadrado;
    }
}
