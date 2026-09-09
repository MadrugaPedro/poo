import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro não negativo: ");
        int n = scanner.nextInt();
        long valor = calcularFibonacci(n);
        System.out.println(formatarSaida(valor, n));
        scanner.close();
    }

    public static long calcularFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O número deve ser não negativo.");
        }
        if (n < 2) return n;

        long anterior = 0;
        long atual = 1;
        for (int i = 2; i <= n; i++) {
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        return atual;
    }

    public static String formatarSaida(long fibonacci, int n) {
        return "O " + n + "º número de Fibonacci é: " + fibonacci;
    }
}
