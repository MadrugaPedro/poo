import java.util.Scanner;

    public class Primo {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            boolean primo = true;

            if(num == 0){
                System.out.println("ZERO");
                return;
            }

            for(int i = 2; i < num / i; i++){
                if(num % i == 0){
                    primo = false;
                    break;
                }
            }

            if(primo){
                System.out.println("PRIMO");
            } else{
                System.out.println("NAO PRIMO");
            }
            
            scanner.close();
        }
    }
