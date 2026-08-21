import java.util.Scanner;

public class Exercicio03{
    public static void main(String[] args){
        Scanner numero = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int numero1 = numero.nextInt();

        System.out.print("Digite o segundo número: ");
        int numero2 = numero.nextInt();

        System.out.print("Digite o terceiro número: ");
        int numero3 = numero.nextInt();

        int maior = numero1;

        if(numero2 > numero1){
            maior = numero2;
        }

        if(numero3 > maior){
            maior = numero3;
        }

        int ocorrencias = 0;

        if(numero1 == maior){ocorrencias++;}
        if(numero2 == maior){ocorrencias++;}
        if(numero3 == maior){ocorrencias++;}

        if(ocorrencias > 1){
            System.out.print("Maior: " + maior + " Empate");
        } else{
            System.out.print("Maior: " + maior);
        }
        
        numero.close();
    }
}