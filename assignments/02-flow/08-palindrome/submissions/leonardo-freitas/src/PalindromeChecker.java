import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isValidInput(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPalindrome(String input) {
        if (!isValidInput(input)) return false;
        String texto = input.trim().toLowerCase();
        int esquerda = 0;
        int direita = texto.length() - 1;
        while (esquerda < direita) {
            if (texto.charAt(esquerda) != texto.charAt(direita)) return false;
            esquerda++;
            direita--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada;
        do {
            System.out.print("Digite uma sequência: ");
            entrada = scanner.nextLine();
            if (!isValidInput(entrada)) System.out.println("Erro: A entrada não pode estar vazia.");
        } while (!isValidInput(entrada));

        System.out.printf("A sequência \"%s\" %s um palíndromo.%n", entrada, isPalindrome(entrada) ? "é" : "não é");
        scanner.close();
    }
}
