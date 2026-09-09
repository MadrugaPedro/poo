import java.util.Scanner;

public class MaiorTresNumeros {
    public static String analisar(int a, int b, int c) {
        int maior = a;
        if (b > maior) {
            maior = b;
        }
        if (c > maior) {
            maior = c;
        }

        int ocorrencias = 0;
        if (a == maior) ocorrencias++;
        if (b == maior) ocorrencias++;
        if (c == maior) ocorrencias++;

        return ocorrencias > 1
                ? "Maior: " + maior + " — EMPATE NO MAIOR VALOR"
                : "Maior: " + maior;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println(analisar(a, b, c));
        scanner.close();
    }
}
