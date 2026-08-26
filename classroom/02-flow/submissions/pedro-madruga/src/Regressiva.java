import java.util.Scanner;

public class Regressiva {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        if (numero <= 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            while (numero >= 0) {
                System.out.print(numero + " ");
                numero--;
            }
            System.out.println("FIM");
        }

        scanner.close();
    }
}

