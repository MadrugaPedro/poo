import java.util.Scanner;

public class NumeroPrimo {
    public static boolean ehPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int divisor = 2; divisor <= numero / divisor; divisor++) {
            if (numero % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        System.out.println(ehPrimo(numero) ? "PRIMO" : "NAO PRIMO");
        scanner.close();
    }
}
