import java.util.Scanner;

    public class IluminacaoLojaApp{
        public static void main(String [] args){
            try(Scanner scanner = new Scanner(System.in)){

                System.out.printf("Digite a potência da vitrine: \n");
                double potenciaVitrine = scanner.nextDouble();
                IluminacaoLoja vitrine = new IluminacaoLoja("Vitrine", potenciaVitrine);

                System.out.printf("Digite a potência do estoque: \n");
                double potenciaEstoque = scanner.nextDouble();
                IluminacaoLoja estoque = new IluminacaoLoja("Estoque", potenciaEstoque);

                vitrine.ligar();

                System.out.println("-- Estado --");
                exibir(vitrine);
                exibir(estoque);
            }
        }
        
        private static void exibir(IluminacaoLoja iluminacao) {
                System.out.println("Setor: " + iluminacao.obterSetor());
                System.out.println("Potência: " + iluminacao.obterPotenciaEmWatts());
                System.out.println("Estado: " + iluminacao.estaLigada());
                }
    }