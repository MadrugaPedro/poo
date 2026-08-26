import java.util.Scanner;

public class PositivoNegativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt(); 
        String tipo;

        if(numero > 0){
            tipo = "positivo";
        }

        else if(numero < 0 ){
            tipo = "negativo";
        }

        else{
            tipo = "zero";
        }

        System.out.println("O numero e " + tipo + ".");

        scanner.close();
    
    }

    
}

