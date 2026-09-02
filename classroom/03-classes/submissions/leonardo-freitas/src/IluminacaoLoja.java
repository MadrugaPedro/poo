public class IluminacaoLoja {
    private String setor;
    private double potenciaEmWatts;
    private boolean ligada;

    public IluminacaoLoja(String setor, double potenciaEmWatts) {
        this.setor = (setor == null || setor.isBlank()) ? "Setor não informado" : setor;
        this.potenciaEmWatts = potenciaEmWatts > 0 ? potenciaEmWatts : 10.0;
        this.ligada = false;
    }

    public void ligar() { ligada = true; }
    public void desligar() { ligada = false; }
    public String obterSetor() { return setor; }
    public double obterPotenciaEmWatts() { return potenciaEmWatts; }
    public boolean estaLigada() { return ligada; }
}
