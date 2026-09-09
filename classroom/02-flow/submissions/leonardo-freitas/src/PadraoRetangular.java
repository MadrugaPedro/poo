import java.util.Scanner;

public class PadraoRetangular {
    public static void desenhar(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            System.out.println("VALOR INVALIDO");
            return;
        }
        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linhas = scanner.nextInt();
        int colunas = scanner.nextInt();
        desenhar(linhas, colunas);
        scanner.close();
    }
}
