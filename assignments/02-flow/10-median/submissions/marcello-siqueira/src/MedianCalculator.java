import java.util.Scanner;

/**
 * Determina a mediana de tres numeros inteiros usando apenas estruturas
 * condicionais, sem ordenar os valores.
 */
public class MedianCalculator {

    /**
     * A mediana e o valor que fica entre os outros dois. Cada numero e testado
     * para verificar se ele esta entre os outros, em qualquer das duas ordens.
     * Valores repetidos tambem sao tratados, porque as comparacoes usam >= e <=.
     */
    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            return a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            return b;
        } else {
            return c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = scanner.nextInt();

        System.out.print("Digite o terceiro número: ");
        int num3 = scanner.nextInt();

        System.out.println("A mediana dos números é: " + findMedian(num1, num2, num3));

        scanner.close();
    }
}
