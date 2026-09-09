import java.util.Scanner;

public class AnaliseAlgarismos {
    public static int[] analisar(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("VALOR INVALIDO");
        }
        if (numero == 0) {
            return new int[] {1, 0};
        }
        int quantidade = 0;
        int soma = 0;
        int atual = numero;
        while (atual > 0) {
            soma += atual % 10;
            quantidade++;
            atual /= 10;
        }
        return new int[] {quantidade, soma};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        if (numero < 0) {
            System.out.println("VALOR INVALIDO");
        } else {
            int[] resultado = analisar(numero);
            System.out.println("Algarismos: " + resultado[0] + " — Soma: " + resultado[1]);
        }
        scanner.close();
    }
}
