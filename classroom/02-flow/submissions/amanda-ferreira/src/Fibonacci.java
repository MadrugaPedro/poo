import java.util.Scanner;

    public class Fibonacci {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            long atual = 0;
            long prox = 1;

            if(N < 0){
                System.out.println("NUMERO INVALIDO");
                return;
            }

            for(int i = 1; i < N; i++){
                System.out.printf(atual + " ");
                long novo = atual + prox;
                atual = prox;
                prox = novo;
            }
            scanner.close();
        }
    }
