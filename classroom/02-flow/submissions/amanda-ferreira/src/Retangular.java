import java.util.Scanner;

    public class Retangular {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int linhas = scanner.nextInt();
            int colunas = scanner.nextInt();

            if(linhas <= 0 || colunas <= 0){
                System.out.println("DIMENSÃO INVÁLIDA");
                return;
            }

            for(int i = 0; i < linhas; i++){
                for(int j = 0; j < colunas; j++){
                    System.out.printf("* ");
                }
                System.out.println();
            }
            scanner.close();
        }
    }
