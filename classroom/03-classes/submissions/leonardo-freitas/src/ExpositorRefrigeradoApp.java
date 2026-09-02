public class ExpositorRefrigeradoApp {
    public static void main(String[] argumentos) {
        ExpositorRefrigerado seguro = new ExpositorRefrigerado();
        ExpositorRefrigerado foraDaFaixa = new ExpositorRefrigerado(10.0);

        exibir("Leitura segura", seguro);
        exibir("Leitura fora da faixa", foraDaFaixa);

        foraDaFaixa.definirTemperatura(6.0);
        exibir("Após ajuste válido", foraDaFaixa);

        foraDaFaixa.definirTemperatura(-300.0);
        exibir("Após leitura fisicamente inválida", foraDaFaixa);
    }

    private static void exibir(String nome, ExpositorRefrigerado expositor) {
        System.out.printf("%s: %.2f °C | Faixa segura: %s%n",
                nome, expositor.obterTemperatura(), expositor.estaNaFaixaSegura() ? "sim" : "não");
    }
}
