import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        int num1 = 0;
        int num2 = 1;

        System.out.print(num1 + " ");
        System.out.print(num2 + " ");

        for (int i = 0; i < numero -2; i++) {
            int proximo = num1 + num2;
            System.out.print(proximo + " ");
            num1 = num2;
            num2 = proximo;
        }

        scanner.close();
    }
}
