import java.util.Scanner;

public class PositivoNegativoZero {
    public static String classificar(int numero) {
        if (numero > 0) {
            return "POSITIVO";
        } else if (numero < 0) {
            return "NEGATIVO";
        } else {
            return "ZERO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        System.out.println(classificar(numero));
        scanner.close();
    }
}
