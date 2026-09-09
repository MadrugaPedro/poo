import java.util.Scanner;

public class ContagemRegressiva {
    public static void exibir(int numero) {
        if (numero < 0) {
            System.out.println("VALOR INVALIDO");
            return;
        }
        int atual = numero;
        while (atual >= 0) {
            System.out.print(atual + " ");
            atual--;
        }
        System.out.println("FIM");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exibir(scanner.nextInt());
        scanner.close();
    }
}
