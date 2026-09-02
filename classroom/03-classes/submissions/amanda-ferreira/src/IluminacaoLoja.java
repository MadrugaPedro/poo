public class IluminacaoLoja{
    private String setor;
    private double potenciaEmWatts;
    private boolean ligada;

    public IluminacaoLoja(String setor, double potencia){
        if(setor == null || setor.isBlank()){
            this.setor = "Setor não informado";
        } else{
            this.setor = setor;
        }

        if(potencia <= 0){
            this.potenciaEmWatts = 10.0;
        } else{
            this.potenciaEmWatts = potencia;
        }

        this.ligada = false;

    }

    public void ligar(){
        this.ligada = true;
    }

    public void desligar(){
        this.ligada = false;
    }
    
    public String obterSetor(){
        return this.setor;
    }

    public double obterPotenciaEmWatts(){
        return this.potenciaEmWatts;
    }

    public boolean estaLigada(){
        return this.ligada;
    }
}