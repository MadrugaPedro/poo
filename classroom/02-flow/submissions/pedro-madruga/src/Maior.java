import java.util.Scanner;

public class Maior {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero1 = scanner.nextInt(); 
        int numero2 = scanner.nextInt();
        int numero3 = scanner.nextInt();
        int maior = numero1;

        if(maior <= numero2)
            maior = numero2;
        else if(maior <= numero3)
            maior = numero3;

        System.out.println("Maior numero: " + maior);

        scanner.close();
    
    }

    
}

