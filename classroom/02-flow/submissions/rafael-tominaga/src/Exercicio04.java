import java.util.Scanner;

public class Exercicio04{
    public static void main(String[] args){
        Scanner numero = new Scanner(System.in);

        System.out.print("Digite o primeiro numero: ");
        double numero1 = numero.nextDouble();

        System.out.print("Digite o segundo numero: ");
        double numero2 = numero.nextDouble();

        System.out.print("Digite o operador (+, -, *, /):");
        char operador = numero.next().charAt(0);

        switch(operador){
            case '+' -> System.out.println(numero1 + numero2);
            case '-' -> System.out.println(numero1 - numero2);
            case '*' -> System.out.println(numero1 * numero2);
            case '/' -> {
                if (numero2 == 0) {
                    System.out.println("Erro: Divisao por zero nao permitida.");
                } else {
                    System.out.println(numero1 / numero2);
                }
            }
            default -> System.out.println("OPERADOR INVALIDO");
        }

        numero.close();
    }
}
