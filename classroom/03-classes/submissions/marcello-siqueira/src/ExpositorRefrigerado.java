/**
 * Monitora a temperatura de um expositor refrigerado.
 * A faixa segura de conservacao vai de 2.0 a 8.0 graus Celsius.
 */
public class ExpositorRefrigerado {

    private static final double ZERO_ABSOLUTO = -273.15;
    private static final double TEMPERATURA_MINIMA_SEGURA = 2.0;
    private static final double TEMPERATURA_MAXIMA_SEGURA = 8.0;
    private static final double TEMPERATURA_PADRAO = 4.0;

    private double temperatura;

    /**
     * Construtor sem argumento delega para o construtor principal com o
     * valor padrao, para que a regra de normalizacao exista em um lugar so.
     */
    public ExpositorRefrigerado() {
        this(TEMPERATURA_PADRAO);
    }

    public ExpositorRefrigerado(double temperatura) {
        if (temperatura < ZERO_ABSOLUTO) {
            this.temperatura = TEMPERATURA_PADRAO;
        } else {
            this.temperatura = temperatura;
        }
    }

    /**
     * Leitura fisicamente impossivel e ignorada e o estado anterior permanece.
     */
    public void definirTemperatura(double temperatura) {
        if (temperatura >= ZERO_ABSOLUTO) {
            this.temperatura = temperatura;
        }
    }

    public double obterTemperatura() {
        return temperatura;
    }

    public boolean estaNaFaixaSegura() {
        return temperatura >= TEMPERATURA_MINIMA_SEGURA && temperatura <= TEMPERATURA_MAXIMA_SEGURA;
    }
}
