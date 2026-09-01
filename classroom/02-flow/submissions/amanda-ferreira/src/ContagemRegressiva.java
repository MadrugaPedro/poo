import java.util.Scanner;

    public class ContagemRegressiva {
        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            while(num > -1){
                System.out.print(num + " ");
                num -= 1;
            }
            System.out.print("FIM");
            scanner.close();
        }
    }
