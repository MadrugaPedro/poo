import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        char operador = scanner.next().charAt(0);

        switch (operador) {
            case '+' -> System.out.println(num1 + num2);
            case '-' -> System.out.println(num1 - num2);
            case '*' -> System.out.println(num1 * num2);
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Nao e possivel dividir por 0");
                } else {
                    System.out.println(num1 / num2);
                }
            }
            default -> System.out.println("Operador invalido");
        }
        
        scanner.close();
    }
}