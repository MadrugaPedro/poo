import java.util.Scanner;

    public class Aprovacao{
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int nota_um = scanner.nextInt();
            int nota_dois = scanner.nextInt();
            double media;
            String resultado;

            media = (nota_um + nota_dois) / 2.0;

            if(media >= 7 && media <= 10)
                resultado = "APROVADO";
            else if(media < 7 && media >= 5)
                resultado = "RECUPERACAO";
            else if(media < 5 && media >= 0)
                resultado = "REPROVADO";
            else
                resultado = "NOTA INVALIDA";

            scanner.close();

            System.out.println("Média "+ media +" - "+ resultado +"");
        }
    }