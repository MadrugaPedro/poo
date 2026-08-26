import java.util.Scanner;

public class Retangulo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();


        for (int i = 1; i <= num1; i++){
            for (int j = 1; j <= num2 ; j++){
                System.out.print("*");
                
            }
            System.out.println(" ");

        }
                
               

          

    scanner.close();
    
}
    }


