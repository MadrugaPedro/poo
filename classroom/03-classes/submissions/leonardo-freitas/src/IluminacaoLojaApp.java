public class IluminacaoLojaApp {
    public static void main(String[] argumentos) {
        IluminacaoLoja vitrine = new IluminacaoLoja("Vitrine", 120.0);
        IluminacaoLoja estoque = new IluminacaoLoja("Estoque", 80.0);

        vitrine.ligar();

        exibir(vitrine);
        exibir(estoque);
    }

    private static void exibir(IluminacaoLoja iluminacao) {
        System.out.printf("Setor: %s | Potência: %.1f W | Estado: %s%n",
                iluminacao.obterSetor(),
                iluminacao.obterPotenciaEmWatts(),
                iluminacao.estaLigada() ? "ligada" : "desligada");
    }
}
