import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero: ");
        int numero = scanner.nextInt();

        if(numero > 0){
            System.out.println("Positivo");
        } else if(numero < 0){
            System.out.println("Negativo");
        } else{
            System.out.println("Zero");
        }

        scanner.close();
    }
}
