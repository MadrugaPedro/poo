/**
 * Demonstra que dois objetos da mesma classe mantem estados independentes.
 */
public class IluminacaoLojaApp {

    public static void main(String[] argumentos) {
        IluminacaoLoja vitrine = new IluminacaoLoja("Vitrine", 150.0);
        IluminacaoLoja estoque = new IluminacaoLoja("Estoque", 90.0);

        System.out.println("Estado inicial");
        exibir(vitrine);
        exibir(estoque);

        vitrine.ligar();

        System.out.println();
        System.out.println("Depois de ligar somente a vitrine");
        exibir(vitrine);
        exibir(estoque);

        IluminacaoLoja invalida = new IluminacaoLoja("   ", -50.0);

        System.out.println();
        System.out.println("Caso de fronteira: setor vazio e potência negativa");
        exibir(invalida);
    }

    private static void exibir(IluminacaoLoja iluminacao) {
        String situacao;

        if (iluminacao.estaLigada()) {
            situacao = "ligada";
        } else {
            situacao = "desligada";
        }

        System.out.printf("%s | %.1f W | %s%n",
                iluminacao.obterSetor(), iluminacao.obterPotenciaEmWatts(), situacao);
    }
}
