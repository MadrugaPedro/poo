import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args){
        Scanner notas = new Scanner(System.in);

        System.out.print("Digite a primeira nota: ");
        double nota1 = notas.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = notas.nextDouble();

        if(nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10){
            System.out.println("Digite um valor entre 0 a 10");
        } else{
            double media = (nota1 + nota2)/2;
            System.out.printf("A media é %.2f", media);
        }

        notas.close();
    }
}   
