import java.util.Scanner;

/**
 * Gera a sequencia de Collatz a partir de um numero inteiro positivo:
 * numeros pares sao divididos por 2 e numeros impares sao multiplicados
 * por 3 e somados a 1, ate que a sequencia chegue a 1.
 */
public class CollatzSequence {

    /**
     * Retorna o proximo numero da sequencia de Collatz.
     */
    public static int nextCollatz(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        if (n % 2 == 0) {
            return n / 2;
        }

        return (n * 3) + 1;
    }

    /**
     * Percorre a sequencia a partir de n e retorna a soma de todos os termos,
     * incluindo o proprio n e o 1 do final.
     */
    public static int calculateCollatzSum(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        int sum = n;
        int current = n;

        while (current != 1) {
            current = nextCollatz(current);
            sum = sum + current;
        }

        return sum;
    }

    /**
     * Monta a sequencia completa em texto, no formato 6 -> 3 -> 10 -> ... -> 1.
     */
    public static String buildSequence(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }

        String sequence = String.valueOf(n);
        int current = n;

        while (current != 1) {
            current = nextCollatz(current);
            sequence = sequence + " → " + current;
        }

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }

        int seed = scanner.nextInt();

        if (seed < 1) {
            System.out.println("Erro: O número deve ser um inteiro positivo.");
            scanner.close();
            return;
        }

        System.out.println("Sequência de Collatz: " + buildSequence(seed));
        System.out.println("Soma dos termos: " + calculateCollatzSum(seed));

        scanner.close();
    }
}
