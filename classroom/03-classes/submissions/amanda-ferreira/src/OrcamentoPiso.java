public class OrcamentoPiso {
    private final double comprimento;
    private final double largura;
    private final double precoPorMetroQuadrado;

    public OrcamentoPiso(double comprimento, double largura, double precoPorMetroQuadrado){
        if(comprimento <= 0){
            this.comprimento = 1.0;
        } else{
            this.comprimento = comprimento;
        }

        if(largura <= 0){
            this.largura = 1.0;
        } else{
            this.largura = largura;
        }

        if(precoPorMetroQuadrado < 0){
            this.precoPorMetroQuadrado = 0;
        } else{
            this.precoPorMetroQuadrado = precoPorMetroQuadrado;
        }
    }

    public double obterComprimento(){
        return this.comprimento;
    }

    public double obterLargura(){
        return this.largura;
    }

    public double obterPrecoPorMetroQuadrado(){
        return this.precoPorMetroQuadrado;
    }

    public double calcularArea(){
        return this.comprimento * this.largura;
    }

    public double calcularComprimentoRodape(){
        return 2 * (this.comprimento + this.largura);
    }

    public double calcularPrecoTotal(){
        return this.calcularArea() * this.precoPorMetroQuadrado;
    }

}
