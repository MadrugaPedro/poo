import java.util.Scanner;

    public class Positivonegativo {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int numero = scanner.nextInt();
            String valor;

            if(numero > 0)
                valor = "POSITIVO";
            else if(numero < 0)
                valor = "NEGATIVO";
            else
                valor = "ZERO";

            scanner.close();

            System.out.println(""+ valor +"");
        }
    } 