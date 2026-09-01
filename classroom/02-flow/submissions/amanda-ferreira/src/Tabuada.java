import java.util.Scanner;

    public class Tabuada {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int multiplicado = 0;

            for(int i = 0; i < 11; i++){
                multiplicado = num * i;
                System.out.println(num + " x " + i + " = " + multiplicado);
            }
            scanner.close();
        }
    }
