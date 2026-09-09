import java.util.Scanner;

public class Tabuada {
    public static void exibir(int numero) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exibir(scanner.nextInt());
        scanner.close();
    }
}
