import java.util.Scanner;

    public class Algarismos {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int numRestante = num;
            int soma = 0;
            int qtdAlgarismos = 0;

            if(num < 0){
                System.out.println("NUMERO INVALIDO");
                return;
            }

            while(numRestante > 0){
                soma += numRestante % 10;
                numRestante /= 10;
                qtdAlgarismos++;
            }
            System.out.printf("Algarismos: %d - Soma: %d%n", qtdAlgarismos, soma);
            scanner.close();
        }
    }
