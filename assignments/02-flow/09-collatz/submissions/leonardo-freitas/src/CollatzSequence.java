import java.util.Scanner;

public class CollatzSequence {
    public static int nextCollatz(int n) {
        if (n < 1) throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        return n % 2 == 0 ? n / 2 : n * 3 + 1;
    }

    public static long calculateCollatzSum(int n) {
        if (n < 1) throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        long soma = n;
        int atual = n;
        while (atual != 1) {
            atual = nextCollatz(atual);
            soma += atual;
        }
        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro positivo: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }
        System.out.print("Sequência de Collatz: " + n);
        int atual = n;
        while (atual != 1) {
            atual = nextCollatz(atual);
            System.out.print(" → " + atual);
        }
        System.out.println();
        System.out.println("Soma dos termos: " + calculateCollatzSum(n));
        scanner.close();
    }
}
