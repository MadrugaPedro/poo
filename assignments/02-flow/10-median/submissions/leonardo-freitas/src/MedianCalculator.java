import java.util.Scanner;

public class MedianCalculator {
    public static int findMedian(int a, int b, int c) {
        if ((a >= b && a <= c) || (a >= c && a <= b)) return a;
        if ((b >= a && b <= c) || (b >= c && b <= a)) return b;
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        int a = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int b = scanner.nextInt();
        System.out.print("Digite o terceiro número: ");
        int c = scanner.nextInt();
        System.out.println("A mediana dos números é: " + findMedian(a, b, c));
        scanner.close();
    }
}
