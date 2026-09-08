import java.util.Scanner;

public class CalculadoraSimples {
    public static String calcular(double a, char operador, double b) {
        return switch (operador) {
            case '+' -> Double.toString(a + b);
            case '-' -> Double.toString(a - b);
            case '*' -> Double.toString(a * b);
            case '/' -> b == 0 ? "DIVISAO POR ZERO" : Double.toString(a / b);
            default -> "OPERADOR INVALIDO";
        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        char operador = scanner.next().charAt(0);
        double b = scanner.nextDouble();
        System.out.println(calcular(a, operador, b));
        scanner.close();
    }
}
