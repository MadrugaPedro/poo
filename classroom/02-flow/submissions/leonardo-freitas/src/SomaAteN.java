import java.util.Scanner;

public class SomaAteN {
    public static long somar(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("VALOR INVALIDO");
        }
        long soma = 0;
        for (int i = 1; i <= n; i++) {
            soma += i;
        }
        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            System.out.println(somar(n));
        }
        scanner.close();
    }
}
