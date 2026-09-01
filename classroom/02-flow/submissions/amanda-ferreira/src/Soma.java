import java.util.Scanner;

    public class Soma {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int soma = 0;

            for(int i = 0; i <= N; i++){
                if(N < 0){
                    System.out.println("VALOR INVALIDO");
                }else {
                    soma += i;
                }
            }
            System.out.println(soma);

            scanner.close();
        }
    }
