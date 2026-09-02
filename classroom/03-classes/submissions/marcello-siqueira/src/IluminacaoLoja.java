/**
 * Controla a iluminacao de um setor da loja.
 * Cada objeto guarda o proprio estado, por isso ligar um setor
 * nao interfere em nenhum outro.
 */
public class IluminacaoLoja {

    private static final String SETOR_PADRAO = "Setor não informado";
    private static final double POTENCIA_PADRAO = 10.0;

    private String setor;
    private double potenciaEmWatts;
    private boolean ligada;

    /**
     * Normaliza os argumentos invalidos no proprio construtor, para que
     * nenhum objeto exista com estado invalido.
     */
    public IluminacaoLoja(String setor, double potenciaEmWatts) {
        if (setor == null || setor.trim().isEmpty()) {
            this.setor = SETOR_PADRAO;
        } else {
            this.setor = setor;
        }

        if (potenciaEmWatts <= 0) {
            this.potenciaEmWatts = POTENCIA_PADRAO;
        } else {
            this.potenciaEmWatts = potenciaEmWatts;
        }

        this.ligada = false;
    }

    public void ligar() {
        this.ligada = true;
    }

    public void desligar() {
        this.ligada = false;
    }

    public String obterSetor() {
        return setor;
    }

    public double obterPotenciaEmWatts() {
        return potenciaEmWatts;
    }

    public boolean estaLigada() {
        return ligada;
    }
}
