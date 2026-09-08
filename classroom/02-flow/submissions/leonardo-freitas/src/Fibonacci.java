import java.util.Scanner;

public class Fibonacci {
    public static void exibir(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("VALOR INVALIDO");
            return;
        }
        long anterior = 0;
        long atual = 1;
        for (int i = 0; i < quantidade; i++) {
            System.out.print(anterior);
            if (i < quantidade - 1) {
                System.out.print(" ");
            }
            long proximo = anterior + atual;
            anterior = atual;
            atual = proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exibir(scanner.nextInt());
        scanner.close();
    }
}
