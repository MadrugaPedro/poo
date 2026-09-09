import java.util.Locale;
import java.util.Scanner;

public class CalculadoraPoligono {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de lados do polígono: ");
        int n = scanner.nextInt();
        System.out.print("Digite o comprimento do lado em metros: ");
        double s = scanner.nextDouble();
        System.out.println(formatarSaida(calcularArea(n, s)));
        scanner.close();
    }

    public static double calcularArea(int n, double s) {
        if (n < 3 || s <= 0) {
            throw new IllegalArgumentException("Número de lados deve ser >= 3 e comprimento do lado deve ser positivo.");
        }
        return 0.25 * s * s * n / Math.tan(Math.PI / n);
    }

    public static String formatarSaida(double area) {
        return String.format(Locale.US, "A área do polígono é: %.2f metros quadrados", area);
    }
}
