import java.util.Scanner;

public class Algorismos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("VALOR INVALIDO");
        } else if (numero == 0) {
            System.out.println("Algarismos: 1 — Soma: 0");
        } else {
            int quantidade = 0;
            int soma = 0;
            int temp = numero;

            while (temp > 0) {
                int ultimoAlgarismo = temp % 10;
                soma += ultimoAlgarismo;
                quantidade++;
                temp /= 10;
            }

            System.out.println("Algarismos: " + quantidade + " — Soma: " + soma);
        }

        scanner.close();
    }
}
