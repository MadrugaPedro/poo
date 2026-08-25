import java.util.Scanner;

public class Notas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nota1 = scanner.nextDouble(); 
        double nota2 = scanner.nextDouble();
        double media = (nota1 + nota2)/2; 
        String status;

        if(media >= 7)
            status = "APROVADO";

        else if(media <= 7 && media >= 5 )
            status = "RECUPERACAO";

        else if(media < 5 )
            status = "REPROVADO";

        else
            status = "NOTA INVALIDA";

        System.out.println("Media: " + media + " - " + status);

        scanner.close();
    
    }

    
}

