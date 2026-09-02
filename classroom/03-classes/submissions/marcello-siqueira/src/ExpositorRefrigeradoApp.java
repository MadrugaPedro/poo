/**
 * Demonstra os dois construtores, um ajuste valido e uma leitura invalida.
 */
public class ExpositorRefrigeradoApp {

    public static void main(String[] argumentos) {
        ExpositorRefrigerado padrao = new ExpositorRefrigerado();
        exibir("Expositor sem temperatura informada", padrao);

        ExpositorRefrigerado quente = new ExpositorRefrigerado(12.0);
        exibir("Expositor iniciado a 12.0 °C", quente);

        ExpositorRefrigerado impossivel = new ExpositorRefrigerado(-300.0);
        exibir("Expositor iniciado abaixo do zero absoluto", impossivel);

        System.out.println();
        System.out.println("Ajuste válido para 6.5 °C no expositor que estava a 12.0 °C");
        quente.definirTemperatura(6.5);
        exibir("Depois do ajuste", quente);

        System.out.println();
        System.out.println("Leitura inválida de -280.0 °C, deve ser ignorada");
        quente.definirTemperatura(-280.0);
        exibir("Depois da leitura inválida", quente);
    }

    private static void exibir(String nome, ExpositorRefrigerado expositor) {
        String faixa;

        if (expositor.estaNaFaixaSegura()) {
            faixa = "dentro da faixa segura";
        } else {
            faixa = "FORA da faixa segura";
        }

        System.out.printf("%s: %.2f °C, %s%n", nome, expositor.obterTemperatura(), faixa);
    }
}
